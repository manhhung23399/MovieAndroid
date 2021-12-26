package com.manhhung.movie.ui.movieDetail

import android.util.Log
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Cast
import com.manhhung.movie.data.model.Company
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.data.model.MovieDetail
import com.manhhung.movie.databinding.FragmentMovieDetailBinding
import com.manhhung.movie.ui.adapter.CastAdapter
import com.manhhung.movie.ui.adapter.CompanyAdapter
import com.manhhung.movie.ui.adapter.GenresAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val layoutId = R.layout.fragment_movie_detail
    override val viewModel by sharedViewModel<MovieDetailViewModel>()
    private val castAdapter = CastAdapter(::onCastClick)
    private val companyAdapter = CompanyAdapter(::onCompanyClick)
    private val genresAdapter = GenresAdapter(::onGenresClick)
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private var player: SimpleExoPlayer? = null
    private lateinit var movieDetailTemp: MovieDetail
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun initViews() {

    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            movieDetailVM = viewModel
            recyclerCast.adapter = castAdapter
            recyclerCompany.adapter = companyAdapter
            recyclerGenres.adapter = genresAdapter
        }
        viewModel.apply {
            getMovieDetail(args.movie.id)
            checkFavorite(args.movie.id)
            movieDetail.observe(viewLifecycleOwner,{
                movieDetailTemp = it
            })
        }
    }

    override fun initActions() {
        binding?.apply {
            imageBack.setOnClickListener {
                if (findNavController().previousBackStackEntry?.destination?.label == "DialogExoFullscreen") {
                    val action =
                        MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
                    findNavController().navigate(action)
                } else {
                    findNavController().popBackStack()
                }
            }
            imageSave.setOnClickListener {
                viewModel.insertMovie(args.movie)
            }
            playVideo.findViewById<ImageView>(R.id.buttonFullscreen).apply {
                setOnClickListener {
                    val action =
                        player?.let { it1 ->
                            MovieDetailFragmentDirections.actionMovieDetailFragmentToDialogExoFullscreen(
                                movieDetailTemp.sources[0].file,
                                it1.currentPosition,
                                args.movie
                            )

                        }
                    player?.stop()
                    if (action != null) {
                        findNavController().navigate(action)
                    }
                }
            }
        }
        onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        initExo()
    }

    override fun onStop() {
        super.onStop()
        releaseExo()
    }

    private fun onCastClick(cast: Cast) {

    }

    private fun onCompanyClick(company: Company) {

    }

    private fun onGenresClick(genres: Genre) {

    }

    private fun initExo() {
        if (findNavController().previousBackStackEntry?.destination?.label == "DialogExoFullscreen") {
            viewModel.apply {
                currentPosition.observe(viewLifecycleOwner, { current ->
                    playbackPosition = current
                    player = SimpleExoPlayer.Builder(requireContext())
                        .build()
                        .also { exoPlayer ->
                            binding?.playVideo?.player = exoPlayer
                            movieDetail.observe(viewLifecycleOwner, {
                                val mediaItem = MediaItem.fromUri(it.sources[0].file)
                                exoPlayer.setMediaItem(mediaItem)
                                exoPlayer.playWhenReady = playWhenReady
                                exoPlayer.seekTo(currentWindow, playbackPosition)
                                exoPlayer.prepare()
                            })
                        }
                })
            }
        } else {
            player = SimpleExoPlayer.Builder(requireContext())
                .build()
                .also { exoPlayer ->
                    binding?.playVideo?.player = exoPlayer
                    viewModel.movieDetail.observe(viewLifecycleOwner, {
                        val mediaItem = MediaItem.fromUri(it.sources[0].file)
                        exoPlayer.setMediaItem(mediaItem)
                        exoPlayer.playWhenReady = playWhenReady
                        exoPlayer.seekTo(currentWindow, playbackPosition)
                        exoPlayer.prepare()
                    })
                }
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
                if (findNavController().previousBackStackEntry?.destination?.label == "DialogExoFullscreen") {
                    val action =
                        MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
                    findNavController().navigate(action)
                } else {
                    findNavController().popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}
