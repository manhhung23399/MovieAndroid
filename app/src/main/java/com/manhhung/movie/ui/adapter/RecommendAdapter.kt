package com.manhhung.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.ItemRecommendBinding

class RecommendAdapter(
    private val onItemClick: (Movie) -> Unit
) : BaseAdapter<Movie, RecommendAdapter.RecommendViewHolder>(Movie.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecommendViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recommend,
                parent,
                false
            ), onItemClick
        )

    class RecommendViewHolder(
        private val itemRecommendBinding: ItemRecommendBinding,
        onItemClick: (Movie) -> Unit
    ) : BaseViewHolder<Movie>(itemRecommendBinding, onItemClick) {

        override fun bindData(item: Movie) {
            super.bindData(item)
            itemRecommendBinding.movie = item
        }
    }
}
