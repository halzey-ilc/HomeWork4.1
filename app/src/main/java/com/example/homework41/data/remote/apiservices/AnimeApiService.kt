package com.example.homework41.data.remote.apiservices

import com.example.homework41.data.models.DataItem
import com.example.homework41.data.models.Detail
import com.example.homework41.data.models.Responce
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Responce<DataItem>

    @GET("anime/{id}")
    suspend fun fetchAnimeDetail(
        @Path("id") id:Int
    ): Detail
}