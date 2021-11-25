package com.manhhung.movie.ui.dialogMovieDetail

import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseBottomSheetDialogFragment
import com.manhhung.movie.databinding.DialogMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailDialog : BaseBottomSheetDialogFragment<DialogMovieDetailBinding>() {
    override val layoutResources = R.layout.dialog_movie_detail
    override val viewModel by viewModel<MovieDetailDialogViewModel>()


    override fun setupData() {
    }

    override fun setupViews() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            movieDetailDialogVM = viewModel
        }
    }

    override fun setupActions() {
    }
}