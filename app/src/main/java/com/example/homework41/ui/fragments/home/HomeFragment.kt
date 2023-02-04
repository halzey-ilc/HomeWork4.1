package com.example.homework41.ui.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework41.R
import com.example.homework41.databinding.FragmentHomeBinding
import com.example.homework41.ui.adapters.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home2) {

    private val VM: HomeViewModel by viewModels()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val adapter = HomeAdapter(this::onClickListeners)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerviewRating.adapter = adapter
    }

    private fun setupObserves() {
        VM.fetchAnime().observe(viewLifecycleOwner) {
            adapter.submitList(it.data)
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFormFragment(id.toInt()))
    }

}