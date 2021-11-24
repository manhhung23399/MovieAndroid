package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}