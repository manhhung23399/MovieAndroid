package com.manhhung.movie.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    @SerializedName("key")
    val key: String,
    @SerializedName("massage")
    val message: String,
    @SerializedName("when")
    val date: String,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("photo_url")
    val avatar: String
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem.key == newItem.key

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem == newItem
        }
    }
}
