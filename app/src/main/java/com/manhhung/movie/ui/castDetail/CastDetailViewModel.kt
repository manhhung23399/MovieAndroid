package com.manhhung.movie.ui.castDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.CastDetail
import com.manhhung.movie.data.repository.CastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CastDetailViewModel(
    private val castRepository: CastRepository
) : BaseViewModel() {

    private val _castDetail = MutableLiveData<CastDetail>()
    val castDetail: LiveData<CastDetail>
        get() = _castDetail

    fun getCastDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val castDetail = castRepository.getCastDetail(id)
            _castDetail.postValue(castDetail.data)
        }
    }
}
