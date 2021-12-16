package com.manhhung.movie.ui.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun getMovieDetail(movieId: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieDetailFromApi = movieRepository.getMovieDetail(movieId)
            _movieDetail.postValue(movieDetailFromApi)
        }
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            if (isFavorite.value == true) {
                movieRepository.deleteMovie(movie)
                _isFavorite.postValue(false)
            } else {
                movieRepository.insertMovie(movie)
                _isFavorite.postValue(true)
            }
        }
    }

    fun checkFavorite(id: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieFavorite = movieRepository.isFavorite(id)
            _isFavorite.postValue(movieFavorite != null)
        }
    }
}
