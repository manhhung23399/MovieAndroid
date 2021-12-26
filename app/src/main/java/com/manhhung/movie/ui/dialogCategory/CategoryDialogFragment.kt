package com.manhhung.movie.ui.dialogCategory

import com.manhhung.movie.R
import com.manhhung.movie.base.BaseDialogFragment
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.databinding.DialogGenresBinding
import com.manhhung.movie.ui.adapter.CategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryDialogFragment : BaseDialogFragment<DialogGenresBinding>() {

    override val layoutResources = R.layout.dialog_genres
    override val viewModel by viewModel<CategoryViewModel>()
    private val categoryAdapter = CategoryAdapter(::onItemClick)

    override fun getTheme() = R.style.FullScreenDialog

    override fun setupViews() {

    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            categoryVM = viewModel
            recyclerGenres.adapter = categoryAdapter
        }
    }

    override fun initActions() {
        binding?.buttonClose?.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun onItemClick(genre: Genre) {

    }
}