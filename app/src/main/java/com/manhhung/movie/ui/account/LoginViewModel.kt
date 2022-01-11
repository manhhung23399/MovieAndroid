package com.manhhung.movie.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.model.AccountResponse
import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.Register
import com.manhhung.movie.data.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

open class LoginViewModel(
    private val accountRepository: AccountRepository
) : BaseViewModel() {

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess
    private val _account = MutableLiveData<BaseResponse<Any>>()
    val account: LiveData<BaseResponse<Any>>
        get() = _account
//    private val _accountResponse = MutableLiveData<AccountResponse>()
//    val accountResponse: LiveData<AccountResponse>
//        get() = _accountResponse


    fun logIn(account: Account) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val accountResponse = accountRepository.logIn(account)
            if (accountResponse.success) {
                _isSuccess.postValue(true)
                _account.postValue(accountResponse)
            } else {
                _isSuccess.postValue(false)
                _account.postValue(accountResponse)
            }

        }
    }

}
