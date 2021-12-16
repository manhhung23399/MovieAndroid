package com.manhhung.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Cast
import com.manhhung.movie.databinding.ItemCastBinding

class CastAdapter(
    private val onItemClick: (Cast) -> Unit
) : BaseAdapter<Cast, CastAdapter.CastViewHolder>(Cast.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CastViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_cast,
                parent,
                false
            ), onItemClick
        )

    class CastViewHolder(
        private val itemCastBinding: ItemCastBinding,
        onItemClick: (Cast) -> Unit
    ) : BaseViewHolder<Cast>(itemCastBinding, onItemClick) {

        override fun bindData(item: Cast) {
            super.bindData(item)
            itemCastBinding.cast = item
        }
    }
}
