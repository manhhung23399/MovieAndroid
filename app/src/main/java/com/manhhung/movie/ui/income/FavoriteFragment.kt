package com.manhhung.movie.ui.income

import androidx.navigation.fragment.findNavController
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentFavoriteBinding
import com.manhhung.movie.ui.adapter.FavoriteAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override val layoutId = R.layout.fragment_favorite
    override val viewModel by viewModel<FavoriteViewModel>()
    private val favoriteAdapter = FavoriteAdapter(::onItemClick)

    override fun initViews() {

    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            favoriteVM = viewModel
            recyclerFavorite.adapter = favoriteAdapter
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

    }
}