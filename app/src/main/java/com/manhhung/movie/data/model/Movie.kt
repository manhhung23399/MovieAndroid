package com.manhhung.movie.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo(name = "poster")
    @SerializedName("poster")
    val poster: String,
    @ColumnInfo(name = "backdrop")
    @SerializedName("backdrop")
    val backdrop: String
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem == newItem
        }
    }
}
