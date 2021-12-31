package com.manhhung.movie.ui.account

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Account
import com.manhhung.movie.databinding.FragmentLoginBinding
import com.manhhung.movie.utils.showToast
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override val layoutId = R.layout.fragment_login
    override val viewModel by sharedViewModel<LoginViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            loginVM = viewModel
        }
        viewModel.apply {
            isSuccess.observe(viewLifecycleOwner, { it ->
                if (it) {
                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                    findNavController().navigate(action)
                } else {
                    account.observe(viewLifecycleOwner, {
                        context?.showToast(it.message)
                    })
                }
            })
        }
    }

    override fun initActions() {
        binding?.apply {
            buttonLogin.setOnClickListener {
                viewModel.logIn(Account(editEmail.text.toString(), editPass.text.toString()))
            }
            buttonRegister.setOnClickListener {
                val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                findNavController().navigate(action)
            }
        }
    }
}
