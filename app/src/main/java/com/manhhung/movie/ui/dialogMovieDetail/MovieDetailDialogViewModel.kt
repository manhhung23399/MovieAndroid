package com.manhhung.movie.ui.dialogMovieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.MovieDetail
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailDialogViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    fun getMovieDetail(movieId: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieDetailFromApi = movieRepository.getMovieDetail(movieId)
            _movieDetail.postValue(movieDetailFromApi.data)
        }
    }
}
