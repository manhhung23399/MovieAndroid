package com.manhhung.movie.di

import com.manhhung.movie.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<AccountRepository> { AccountRepositoryImpl(get()) }
}
