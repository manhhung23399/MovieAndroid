package com.manhhung.movie.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

open class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    protected val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage
    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is UnknownHostException -> viewModelScope.launch {
                _errorMessage.value = "Kiểm tra lại kêt nối mạng!"
            }
            is HttpException-> viewModelScope.launch {
                _errorMessage.value = "Kiểm tra lại thông tin đăng nhập!"
            }
            else -> viewModelScope.launch {_errorMessage.value = throwable.message}
        }

    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
