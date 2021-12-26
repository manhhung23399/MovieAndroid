package com.manhhung.movie.ui.dialogCategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhhung.movie.base.BaseViewModel
import com.manhhung.movie.data.model.Genre
import com.manhhung.movie.data.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
) : BaseViewModel() {
    private val _genres = MutableLiveData<List<Genre>>()
    val genres: LiveData<List<Genre>>
        get() = _genres

    init {
        getGenres()
    }

    private fun getGenres() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val genresFromApi = categoryRepository.getGenres()
            _genres.postValue(genresFromApi)
        }
    }
}
