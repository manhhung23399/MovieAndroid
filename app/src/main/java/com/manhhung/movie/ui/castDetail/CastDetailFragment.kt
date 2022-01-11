package com.manhhung.movie.ui.castDetail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentCastDetailBinding
import com.manhhung.movie.ui.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CastDetailFragment : BaseFragment<FragmentCastDetailBinding>() {

    private val movieAdapter = MovieAdapter(::onItemClick)
    private val args: CastDetailFragmentArgs by navArgs()

    override val layoutId = R.layout.fragment_cast_detail
    override val viewModel by viewModel<CastDetailViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            castDetailVM = viewModel
            recyclerMovie.apply {
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
        viewModel.getCastDetail(args.castId)
    }

    override fun initActions() {
        binding?.apply {
            imageBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun onItemClick(movie: Movie) {
        val action =
            CastDetailFragmentDirections.actionCastDetailFragmentToMovieDetailFragment(movie)
        findNavController().navigate(action)
    }
}
