package com.manhhung.movie.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("homePage")
    val homePage: String,
    @SerializedName("head")
    val head: String,
    @SerializedName("country")
    val country: String
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Company>() {
            override fun areItemsTheSame(oldItem: Company, newItem: Company) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Company, newItem: Company) =
                oldItem == newItem
        }
    }
}
