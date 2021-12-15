package com.manhhung.movie.ui.movieDetail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.databinding.FragmentMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val layoutId = R.layout.fragment_movie_detail
    override val viewModel by viewModel<MovieDetailViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            movieDetailVM = viewModel
        }
        viewModel.getMovieDetail(args.movieId)
    }

    override fun initActions() {
        binding?.apply {
            imageBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}
