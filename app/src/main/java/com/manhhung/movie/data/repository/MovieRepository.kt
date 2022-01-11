package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.Comment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(): BaseResponse<List<Movie>>
    suspend fun getMovieDetail(movieId: String): BaseResponse<MovieDetail>
    suspend fun getMovieByGenre(idGenre: String, order: String): BaseResponse<List<Movie>>
    suspend fun getRandomMovie(number: Int): BaseResponse<List<Movie>>
    suspend fun getFavoriteMovie(): List<Movie>
    suspend fun insertMovie(movie: Movie)
    suspend fun deleteMovie(movie: Movie)
    suspend fun isFavorite(id: String): Movie
    suspend fun getPopularMovie(order: String): BaseResponse<List<Movie>>
}
