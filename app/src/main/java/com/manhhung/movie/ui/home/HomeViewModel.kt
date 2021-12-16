package com.manhhung.movie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {


    private val _actionMovies = MutableLiveData<List<Movie>>()
    val actionMovies: LiveData<List<Movie>>
        get() = _actionMovies
    private val _fantasyMovies = MutableLiveData<List<Movie>>()
    val fantasyMovies: LiveData<List<Movie>>
        get() = _fantasyMovies
    private val _animationMovies = MutableLiveData<List<Movie>>()
    val animationMovies: LiveData<List<Movie>>
        get() = _animationMovies
    private val _familyMovies = MutableLiveData<List<Movie>>()
    val familyMovies: LiveData<List<Movie>>
        get() = _familyMovies
    private val _horrorMovies = MutableLiveData<List<Movie>>()
    val horrorMovies: LiveData<List<Movie>>
        get() = _horrorMovies
    private val _randomMovie = MutableLiveData<Movie>()
    val randomMovie: LiveData<Movie>
        get() = _randomMovie

    init {
        getRandomMovie()
        getActionMovies()
        getFantasyMovies()
        getHorrorMovies()
        getFamilyMovies()
        getAnimationMovies()
    }

    private fun getActionMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres eq 28")
            _actionMovies.postValue(moviesFromApi)
        }
    }

    private fun getFantasyMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres eq 14")
            _fantasyMovies.postValue(moviesFromApi)
        }
    }

    private fun getAnimationMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres eq 16")
            _animationMovies.postValue(moviesFromApi)
        }
    }

    private fun getHorrorMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres eq 27")
            _horrorMovies.postValue(moviesFromApi)
        }
    }

    private fun getFamilyMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres eq 35")
            _familyMovies.postValue(moviesFromApi)
        }
    }

    private fun getRandomMovie() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieFromApi = movieRepository.getRandomMovie(1)
            _randomMovie.postValue(movieFromApi[0])
        }
    }

}
