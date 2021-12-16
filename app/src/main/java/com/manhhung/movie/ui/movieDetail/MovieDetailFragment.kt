package com.manhhung.movie.ui.movieDetail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Cast
import com.manhhung.movie.data.model.Company
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.databinding.FragmentMovieDetailBinding
import com.manhhung.movie.ui.adapter.CastAdapter
import com.manhhung.movie.ui.adapter.CompanyAdapter
import com.manhhung.movie.ui.adapter.GenresAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val layoutId = R.layout.fragment_movie_detail
    override val viewModel by viewModel<MovieDetailViewModel>()
    private val castAdapter = CastAdapter(::onCastClick)
    private val companyAdapter = CompanyAdapter(::onCompanyClick)
    private val genresAdapter = GenresAdapter(::onGenresClick)

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
        }
    }

    override fun initActions() {
        binding?.apply {
            imageBack.setOnClickListener {
                findNavController().popBackStack()
            }
            imageSave.setOnClickListener {
                viewModel.insertMovie(args.movie)
            }
        }
    }

    private fun onCastClick(cast: Cast) {

    }

    private fun onCompanyClick(company: Company) {

    }

    private fun onGenresClick(genres: Genre) {

    }
}
