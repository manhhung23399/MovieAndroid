package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieDetail(movieId: String): MovieDetail
    suspend fun getMovieByGenre(idGenre: String, order: String): List<Movie>
    suspend fun getRandomMovie(number: Int): List<Movie>
    suspend fun getFavoriteMovie(): List<Movie>
    suspend fun insertMovie(movie: Movie)
    suspend fun deleteMovie(movie: Movie)
    suspend fun isFavorite(id: String): Movie
}
