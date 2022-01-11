package com.manhhung.movie.ui.search

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.navigation.fragment.findNavController
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentSearchBinding
import com.manhhung.movie.ui.adapter.TopSearchAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val topSearchAdapter = TopSearchAdapter(::onItemClick)
    private var timer: Timer? = null
    override val layoutId = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            searchVM = viewModel
            recyclerTopSearch.adapter = topSearchAdapter
        }
    }

    override fun initActions() {
        binding?.apply {
            editSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    timer?.cancel()
                }

                override fun afterTextChanged(p0: Editable?) {
                    if (editSearch.text.isNotEmpty()) {
                        timer = Timer()
                        timer?.schedule(object : TimerTask() {
                            override fun run() {
                                viewModel.searchMovie(editSearch.text.toString())
                            }
                        }, 500)
                    }
                }
            })
            viewModel.topSearch.observe(viewLifecycleOwner, {
                if (it.isNotEmpty()) {
                    textNoResult.visibility = View.GONE
                } else {
                    textNoResult.visibility = View.VISIBLE
                }
            })
        }
    }

    private fun onItemClick(movie: Movie) {
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(movie)
        findNavController().navigate(action)
    }
}
