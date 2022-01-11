package com.manhhung.movie.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.ItemTopSearchBinding

class TopSearchAdapter(
    private val onItemClick: (Movie) -> Unit
) : BaseAdapter<Movie, TopSearchAdapter.MovieViewHolder>(Movie.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_top_search,
                parent,
                false
            ), onItemClick
        )

    class MovieViewHolder(
        private val itemTopSearchBinding: ItemTopSearchBinding,
        onItemClick: (Movie) -> Unit
    ) : BaseViewHolder<Movie>(itemTopSearchBinding, onItemClick) {

        override fun bindData(item: Movie) {
            super.bindData(item)
            itemTopSearchBinding.movie = item
        }
    }
}
