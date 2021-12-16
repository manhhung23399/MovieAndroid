package com.manhhung.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseAdapter
import com.manhhung.movie.base.BaseViewHolder
import com.manhhung.movie.data.model.Company
import com.manhhung.movie.databinding.ItemCompanyBinding

class CompanyAdapter(
    private val onItemClick: (Company) -> Unit
) : BaseAdapter<Company, CompanyAdapter.CompanyViewHolder>(Company.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CompanyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_company,
                parent,
                false
            ), onItemClick
        )

    class CompanyViewHolder(
        private val itemCompanyBinding: ItemCompanyBinding,
        onItemClick: (Company) -> Unit
    ) : BaseViewHolder<Company>(itemCompanyBinding, onItemClick) {

        override fun bindData(item: Company) {
            super.bindData(item)
            itemCompanyBinding.company = item
        }
    }
}