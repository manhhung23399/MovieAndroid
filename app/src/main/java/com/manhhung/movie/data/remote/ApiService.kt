package com.manhhung.movie.data.remote

import com.manhhung.movie.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("movie")
    suspend fun getMovies(): BaseResponse<List<Movie>>

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") id: String
    ): BaseResponse<MovieDetail>

    @GET("movie")
    suspend fun getMovieByGenre(
        @Query("filter") id: String,
        @Query("orderby") order: String
    ): BaseResponse<List<Movie>>

    @GET("movie")
    suspend fun getRandomMovie(
        @Query("random") numberMovie: Int
    ): BaseResponse<List<Movie>>

    @GET("genre")
    suspend fun getGenres(): BaseResponse<List<Genre>>

    @POST("account")
    suspend fun logIn(@Body account: Account): BaseResponse<AccountResponse>
}
