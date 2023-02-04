package com.example.homework41.data.models

import com.example.homework41.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

data class Attributes(
    override val id: String?,

    @SerializedName("description")
    val description: String = "",

    @SerializedName("posterImage")
    val posterImage: PosterImage,

    @SerializedName("titles")
    val titles: Titles,

    @SerializedName("status")
    val status: String = "",
) : BaseDiffModel