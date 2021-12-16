package com.manhhung.movie.di

import com.manhhung.movie.data.repository.MovieRepository
import com.manhhung.movie.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(),get()) }
}
