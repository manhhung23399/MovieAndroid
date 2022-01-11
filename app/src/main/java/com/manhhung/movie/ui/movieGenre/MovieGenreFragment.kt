package com.manhhung.movie.ui.movieGenre

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentMovieGenreBinding
import com.manhhung.movie.ui.adapter.FavoriteAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieGenreFragment : BaseFragment<FragmentMovieGenreBinding>() {

    private val adapter = FavoriteAdapter(::onItemClick)
    private val args: MovieGenreFragmentArgs by navArgs()

    override val layoutId = R.layout.fragment_movie_genre
    override val viewModel by viewModel<MovieGenreViewModel>()
    override fun initViews() {

    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            movieGenreVM = viewModel
            recyclerFavorite.adapter = adapter
        }
        viewModel.apply {
            getMovies(args.genre.id)
            getName(args.genre.name)
        }
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
            MovieGenreFragmentDirections.actionMovieGenreFragmentToMovieDetailFragment(movie)
        findNavController().navigate(action)
    }
}
