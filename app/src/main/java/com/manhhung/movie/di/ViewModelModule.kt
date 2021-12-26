package com.manhhung.movie.di

import com.manhhung.movie.ui.account.LoginViewModel
import com.manhhung.movie.ui.dialogCategory.CategoryViewModel
import com.manhhung.movie.ui.dialogMovieDetail.MovieDetailDialogViewModel
import com.manhhung.movie.ui.home.HomeViewModel
import com.manhhung.movie.ui.income.FavoriteViewModel
import com.manhhung.movie.ui.movieDetail.MovieDetailViewModel
import com.manhhung.movie.ui.search.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { SettingViewModel() }
    viewModel { MovieDetailDialogViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}
