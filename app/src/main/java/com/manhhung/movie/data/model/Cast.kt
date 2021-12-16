package com.manhhung.movie.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cast(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("country")
    val country: String
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Cast>() {
            override fun areItemsTheSame(oldItem: Cast, newItem: Cast) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Cast, newItem: Cast) =
                oldItem == newItem
        }
    }
}
