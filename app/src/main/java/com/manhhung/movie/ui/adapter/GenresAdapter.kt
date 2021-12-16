package com.manhhung.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Cast
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.databinding.ItemCastBinding
import com.manhhung.movie.databinding.ItemGenresBinding

class GenresAdapter(
    private val onItemClick: (Genre) -> Unit
) : BaseAdapter<Genre, GenresAdapter.GenreViewHolder>(Genre.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GenreViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_genres,
                parent,
                false
            ), onItemClick
        )

    class GenreViewHolder(
        private val itemGenresBinding: ItemGenresBinding,
        onItemClick: (Genre) -> Unit
    ) : BaseViewHolder<Genre>(itemGenresBinding, onItemClick) {

        override fun bindData(item: Genre) {
            super.bindData(item)
            itemGenresBinding.genre = item
        }
    }
}
