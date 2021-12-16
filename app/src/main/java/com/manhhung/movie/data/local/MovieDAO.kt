package com.manhhung.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.manhhung.movie.data.model.Movie

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    suspend fun getFavoriteMovies(): List<Movie>

    @Insert(onConflict = IGNORE)
    suspend fun insertMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movie WHERE id =:id")

    fun isFavorite(id: String): Movie
}
