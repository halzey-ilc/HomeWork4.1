package com.example.homework41.data.models

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("tiny")
    val tiny: String = "",
    @SerializedName("medium")
    val medium: String = ""
)