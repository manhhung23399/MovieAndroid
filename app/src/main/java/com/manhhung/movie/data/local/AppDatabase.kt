package com.manhhung.movie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manhhung.movie.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.manhhung.movie.data.local.AppDatabase.Companion.EXPORT_SCHEME
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.utils.Converter

@Database(
    entities = [Movie::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "movieSaved"
        const val EXPORT_SCHEME = false
    }
}
