package com.example.homework41.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.example.homework41.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: AnimeRepository): ViewModel() {

    fun fetchAnime() = repository.fetchAnime()

}