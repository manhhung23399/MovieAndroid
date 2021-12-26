package com.manhhung.movie.ui.account

import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.databinding.FragmentRegisterBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    override val layoutId = R.layout.fragment_register
    override val viewModel by sharedViewModel<LoginViewModel>()

    override fun initViews() {

    }

    override fun initData() {

    }

    override fun initActions() {

    }
}