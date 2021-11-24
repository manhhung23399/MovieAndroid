package com.manhhung.movie.di

import com.manhhung.movie.ui.dialogMovieDetail.MovieDetailDialogViewModel
import com.manhhung.movie.ui.home.HomeViewModel
import com.manhhung.movie.ui.income.IncomeViewModel
import com.manhhung.movie.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { IncomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { MovieDetailDialogViewModel() }
}
