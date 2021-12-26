package com.manhhung.movie.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.model.AccountResponse
import com.manhhung.movie.data.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class LoginViewModel(
    private val accountRepository: AccountRepository
) : BaseViewModel() {

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess
    private val _account = MutableLiveData<Unit>()
    val account: LiveData<Unit>
        get() = _account

    fun logIn(account: Account) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            if (accountRepository.logIn(account).code() == 200) {
                _isSuccess.postValue(true)
                _account.postValue(accountRepository.logIn(account).body())
            } else {
                _account.postValue(accountRepository.logIn(account).errorBody())
                _isSuccess.postValue(false)
            }
        }
    }
}