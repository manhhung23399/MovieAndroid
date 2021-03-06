package com.manhhung.movie.di

import com.manhhung.movie.data.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single {
        get<Retrofit>()
            .create(ApiService::class.java)
    }
}
