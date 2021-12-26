package com.manhhung.movie.data.repository

import com.manhhung.movie.data.local.MovieDAO
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.remote.ApiService

class MovieRepositoryImpl(
    private val apiService: ApiService,
    private val movieDAO: MovieDAO
) : MovieRepository {
    override suspend fun getMovies() = apiService.getMovies()
    override suspend fun getMovieDetail(movieId: String) = apiService.getMovieDetail(movieId)
    override suspend fun getMovieByGenre(idGenre: String, order: String) =
        apiService.getMovieByGenre(idGenre, order)

    override suspend fun getRandomMovie(number: Int) = apiService.getRandomMovie(number)
    override suspend fun getFavoriteMovie() = movieDAO.getFavoriteMovies()
    override suspend fun insertMovie(movie: Movie) = movieDAO.insertMovie(movie)
    override suspend fun deleteMovie(movie: Movie) = movieDAO.deleteMovie(movie)
    override suspend fun isFavorite(id: String) = movieDAO.isFavorite(id)
}
