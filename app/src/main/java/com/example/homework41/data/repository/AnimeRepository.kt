package com.example.homework41.data.repository

import androidx.lifecycle.liveData
import com.example.homework41.data.remote.api.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) {

    fun fetchAnime() = liveData {
        emit(service.fetchAnime())
    }

    fun fetchAnimeDetail(id: Int) = liveData {
        emit(service.fetchAnimeDetail(id = id))
    }
}