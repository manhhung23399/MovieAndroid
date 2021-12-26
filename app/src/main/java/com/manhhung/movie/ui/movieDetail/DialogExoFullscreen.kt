package com.manhhung.movie.ui.movieDetail

import android.content.pm.ActivityInfo
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.databinding.DialogFullScreenBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DialogExoFullscreen : BaseFragment<DialogFullScreenBinding>() {

    override val layoutId = R.layout.dialog_full_screen
    override val viewModel by sharedViewModel<MovieDetailViewModel>()

    private val args: DialogExoFullscreenArgs by navArgs()
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private var player: SimpleExoPlayer? = null

    override fun initViews() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            fullScreenVM = viewModel
        }
    }

    override fun initActions() {
        binding?.player?.findViewById<ImageView>(R.id.buttonFullscreen)?.apply {
            setOnClickListener {
                player?.currentPosition?.let { it1 -> viewModel.setCurrentPosition(it1) }
                val action = DialogExoFullscreenDirections.actionDialogExoFullscreenToMovieDetailFragment(args.movie)
                findNavController().navigate(action)
            }
        }
        onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        initExo()
    }

    override fun onPause() {
        super.onPause()
        releaseExo()
    }

    override fun onStop() {
        super.onStop()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun initExo() {
        player = SimpleExoPlayer.Builder(requireContext())
            .build()
            .also { exoPlayer ->
                binding?.player?.player = exoPlayer
                val mediaItem = MediaItem.fromUri(args.url)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, args.position)
                exoPlayer.prepare()
            }
    }

    private fun releaseExo() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                player?.currentPosition?.let { it1 -> viewModel.setCurrentPosition(it1) }
                val action = DialogExoFullscreenDirections.actionDialogExoFullscreenToMovieDetailFragment(args.movie)
                findNavController().navigate(action)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }

}