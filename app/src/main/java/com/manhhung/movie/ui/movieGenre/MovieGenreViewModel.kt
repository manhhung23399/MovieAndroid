package com.manhhung.movie.ui.movieGenre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieGenreViewModel(private val movieRepository: MovieRepository) : BaseViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    fun getMovies(id: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movies = movieRepository.getMovieByGenre("Genres+eq+$id", "Popularity+desc")
            _movies.postValue(movies.data)
        }
    }

    fun getName(name: String) {
        _name.postValue(name)
    }
}
