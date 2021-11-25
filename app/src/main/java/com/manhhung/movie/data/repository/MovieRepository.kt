package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieDetail(movieId: String): MovieDetail
}
