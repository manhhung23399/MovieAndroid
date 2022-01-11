package com.manhhung.movie.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _topSearch = MutableLiveData<List<Movie>>()
    val topSearch: LiveData<List<Movie>>
        get() = _topSearch

    init {
        getTopSearch()
    }

    private fun getTopSearch() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movies = movieRepository.getPopularMovie("Popularity+desc")
            _topSearch.postValue(movies.data)
        }
    }

    fun searchMovie(title: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi =
                movieRepository.getMovieByGenre("Title+like+$title", "Popularity+desc")
            _topSearch.postValue(moviesFromApi.data)
        }
    }
}
