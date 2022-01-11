package com.manhhung.movie.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.Register
import com.manhhung.movie.data.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val accountRepository: AccountRepository) : BaseViewModel() {

    private val _isSuccessRegister = MutableLiveData<Boolean>()
    val isSuccessRegister: LiveData<Boolean>
        get() = _isSuccessRegister
    private val _register = MutableLiveData<BaseResponse<Any>>()
    val register: LiveData<BaseResponse<Any>>
        get() = _register

    fun register(register: Register) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            if (accountRepository.register(register).success) {
                _isSuccessRegister.postValue(true)
            } else {
                _isSuccessRegister.postValue(false)
            }
            _register.postValue(accountRepository.register(register))
        }
    }

}