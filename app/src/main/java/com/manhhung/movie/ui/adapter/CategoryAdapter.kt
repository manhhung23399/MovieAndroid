package com.manhhung.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val onItemClick: (Genre) -> Unit
) : BaseAdapter<Genre, CategoryAdapter.GenreViewHolder>(Genre.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GenreViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            ), onItemClick
        )

    class GenreViewHolder(
        private val itemCategoryBinding: ItemCategoryBinding,
        onItemClick: (Genre) -> Unit
    ) : BaseViewHolder<Genre>(itemCategoryBinding, onItemClick) {

        override fun bindData(item: Genre) {
            super.bindData(item)
            itemCategoryBinding.genre = item
        }
    }
}
