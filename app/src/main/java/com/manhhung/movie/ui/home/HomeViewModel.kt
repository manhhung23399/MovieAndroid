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

    private val _randomMovie = MutableLiveData<Movie>()
    val randomMovie: LiveData<Movie>
        get() = _randomMovie
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite
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

    init {
        getRandomMovie()
        getActionMovies()
        getFantasyMovies()
        getHorrorMovies()
        getFamilyMovies()
        getAnimationMovies()
    }

    private fun getRandomMovie() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movieFromApi = movieRepository.getRandomMovie(1)
            _randomMovie.postValue(movieFromApi.data[0])
        }
    }

    private fun getActionMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres+eq+28","Popularity+desc")
            _actionMovies.postValue(moviesFromApi.data)
        }
    }

    private fun getFantasyMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres+eq+10749","Popularity+desc")
            _fantasyMovies.postValue(moviesFromApi.data)
        }
    }

    private fun getAnimationMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres+eq+16","Popularity+desc")
            _animationMovies.postValue(moviesFromApi.data)
        }
    }

    private fun getHorrorMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres+eq+27","Popularity+desc")
            _horrorMovies.postValue(moviesFromApi.data)
        }
    }

    private fun getFamilyMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = movieRepository.getMovieByGenre("Genres+eq+35","Popularity+desc")
            _familyMovies.postValue(moviesFromApi.data)
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
