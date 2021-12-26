package com.manhhung.movie.ui.search

import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.databinding.FragmentSettingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    override val layoutId = R.layout.fragment_setting
    override val viewModel by viewModel<SettingViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
