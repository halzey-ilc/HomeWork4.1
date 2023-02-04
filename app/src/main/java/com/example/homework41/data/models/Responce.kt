package com.example.homework41.data.models

import com.google.gson.annotations.SerializedName

data class Responce<T>(
    @SerializedName("data")
    val data: List<T>?,
)