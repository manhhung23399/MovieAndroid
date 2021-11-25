package com.manhhung.movie.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.ItemMovieBinding

class MovieAdapter(
    private val onItemClick: (Movie) -> Unit
) : BaseAdapter<Movie, MovieAdapter.MovieViewHolder>(Movie.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            ), onItemClick
        )

    class MovieViewHolder(
        private val itemMovieBinding: ItemMovieBinding,
        onItemClick: (Movie) -> Unit
    ) : BaseViewHolder<Movie>(itemMovieBinding, onItemClick) {

        override fun bindData(item: Movie) {
            super.bindData(item)
            itemMovieBinding.movie = item
        }
    }
}
