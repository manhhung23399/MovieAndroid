package com.manhhung.movie.data.repository

import com.manhhung.movie.data.remote.ApiService

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {
    override suspend fun getMovies() = apiService.getMovies()
    override suspend fun getMovieDetail(movieId: String) = apiService.getMovieDetail(movieId)
    override suspend fun getMovieByGenre(idGenre: String) = apiService.getMovieByGenre(idGenre)
    override suspend fun getRandomMovie(number: Int) = apiService.getRandomMovie(number)
}
