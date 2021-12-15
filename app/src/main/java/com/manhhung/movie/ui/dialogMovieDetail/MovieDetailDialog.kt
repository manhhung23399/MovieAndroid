package com.manhhung.movie.ui.dialogMovieDetail

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseBottomSheetDialogFragment
import com.manhhung.movie.databinding.DialogMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailDialog : BaseBottomSheetDialogFragment<DialogMovieDetailBinding>() {

    override val layoutResources = R.layout.dialog_movie_detail
    override val viewModel by viewModel<MovieDetailDialogViewModel>()

    private val args: MovieDetailDialogArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.SheetDialog);

    }

    override fun setupViews() {

    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            movieDetailDialogVM = viewModel
        }
        viewModel.getMovieDetail(args.movieId)
    }

    override fun setupActions() {
        binding?.apply {
            buttonClose.setOnClickListener {
                dialog?.cancel()
            }
            buttonDetail.setOnClickListener {
                val action =
                    MovieDetailDialogDirections.actionMovieDetailDialogToMovieDetailFragment(args.movieId)
                findNavController().navigate(action)
            }
        }
    }
}
