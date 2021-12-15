package com.manhhung.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    suspend fun getSavedGames(): List<Movie>

    @Insert(onConflict = IGNORE)
    suspend fun insertGame(movie: Movie)

    @Delete
    suspend fun deleteGame(movieDetail: Movie)

    @Query("SELECT * FROM movie WHERE id =:id")

    fun isFavorite(id: Long): Movie
}
