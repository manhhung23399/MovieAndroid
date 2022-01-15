package com.manhhung.movie.ui.account

import androidx.navigation.fragment.findNavController
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Register
import com.manhhung.movie.databinding.FragmentRegisterBinding
import com.manhhung.movie.utils.showToast
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override val layoutId = R.layout.fragment_register
    override val viewModel by viewModel<RegisterViewModel>()

    override fun initViews() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            registerVM = viewModel
        }
        viewModel.apply {
            isSuccessRegister.observe(viewLifecycleOwner, { it ->
                if (it) {
                    context?.showToast("Đăng ký thành công, vui lòng xác nhận Email")
                    val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                    findNavController().navigate(action)
                } else {
                    register.observe(viewLifecycleOwner, {
                        context?.showToast("Đăng ký thất bại, vui lòng kiểm tra lại thông tin")
                    })
                }
            })
        }
    }

    override fun initData() {

    }

    override fun initActions() {
        binding?.apply {
            buttonRegister.setOnClickListener {
                val password = editPass.text.toString()
                val confirmPassword = editRePass.text.toString()
                val userName = editUserName.text.toString()
                val email = editEmail.text.toString()

                if (email == "" || password == "" || confirmPassword == "" || userName == "") {
                    context?.showToast("Bạn cần nhập đủ dữ liệu trước khi đăng ký")
                } else if (password != confirmPassword) {
                    context?.showToast("Mật khẩu phải giống nhau!")

                } else {
                    viewModel.register(
                        Register(
                            editEmail.text.toString(),
                            password,
                            confirmPassword,
                            editUserName.text.toString()
                        )
                    )
                }
            }
            imageBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}
