package com.manhhung.movie.ui.companyDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.CompanyDetail
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.repository.CompanyRepository
import com.manhhung.movie.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CompanyDetailViewModel(
    private val companyRepository: CompanyRepository,
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _companyDetail = MutableLiveData<CompanyDetail>()
    val companyDetail: LiveData<CompanyDetail>
        get() = _companyDetail
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getCompanyDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val companyDetail = companyRepository.getCompanyDetail(id)
            _companyDetail.postValue(companyDetail.data)
        }
    }

    fun getMovie(id: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val movies = movieRepository.getMovieByGenre("Companies+eq+$id", "Popularity+desc")
            _movies.postValue(movies.data)
        }
    }
}
