package com.example.homework41.ui.fragments.form

import androidx.lifecycle.ViewModel
import com.example.homework41.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val repository: AnimeRepository):ViewModel(){

    fun fetchAnimeDetail(id: Int) = repository.fetchAnimeDetail(id)
}