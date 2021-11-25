package com.manhhung.movie.ui.income

import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.databinding.FragmentIncomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class IncomeFragment : BaseFragment<FragmentIncomeBinding>() {
    override val layoutId = R.layout.fragment_income
    override val viewModel by viewModel<IncomeViewModel>()

    override fun initViews() {

    }

    override fun initData() {

    }

    override fun initActions() {

    }
}