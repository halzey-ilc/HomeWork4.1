package com.example.homework41.ui.fragments.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework41.R
import com.example.homework41.databinding.FragmentAnimeBinding
import com.example.homework41.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_home2) {

    private val viewModel: AnimeViewModel by viewModels()
    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val adapter = AnimeAdapter(this::onClickListeners)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerviewRating.adapter = adapter
    }

    private fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            adapter.submitList(it.data)
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(AnimeFragmentDirections.actionAnimeFragment2ToDetailFragment2(id.toInt()))
    }

}