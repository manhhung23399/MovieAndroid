package com.manhhung.movie.ui.companyDetail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentCompanyDetailBinding
import com.manhhung.movie.ui.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyDetailFragment : BaseFragment<FragmentCompanyDetailBinding>() {

    private val adapter = MovieAdapter(::onItemClick)
    private val args: CompanyDetailFragmentArgs by navArgs()

    override val layoutId = R.layout.fragment_company_detail
    override val viewModel by viewModel<CompanyDetailViewModel>()
    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            companyDetailVM = viewModel
            recyclerMovie.adapter = adapter
        }
        viewModel.apply {
            getCompanyDetail(args.companyId)
            getMovie(args.companyId)
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
            CompanyDetailFragmentDirections.actionCompanyDetailFragmentToMovieDetailFragment(movie)
        findNavController().navigate(action)
    }
}
