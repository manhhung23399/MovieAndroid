package com.manhhung.movie.ui.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Comment
import com.manhhung.movie.data.model.Company
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
    private val _currentPosition = MutableLiveData<Long>()
    val currentPosition: LiveData<Long>
        get() = _currentPosition
    private val _recommends = MutableLiveData<List<Movie>>()
    val recommends: LiveData<List<Movie>>
        get() = _recommends

    fun getMovieDetail(movieId: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieDetailFromApi = movieRepository.getMovieDetail(movieId)
            _movieDetail.postValue(movieDetailFromApi.data)
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

    fun setCurrentPosition(current: Long) {
        _currentPosition.postValue(current)
    }

    fun getRecommends(genreId: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val recommendAPI =
                movieRepository.getMovieByGenre("Genres+eq+$genreId", "Popularity+desc")
            _recommends.postValue(recommendAPI.data)
        }
    }
}
