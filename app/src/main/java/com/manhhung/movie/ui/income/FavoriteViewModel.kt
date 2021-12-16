package com.manhhung.movie.ui.income

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>>
        get() = _favoriteMovies

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val favoriteMoviesFromDB = movieRepository.getFavoriteMovie()
            _favoriteMovies.postValue(favoriteMoviesFromDB)
        }
    }
}
