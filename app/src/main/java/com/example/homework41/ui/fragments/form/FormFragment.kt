package com.example.homework41.ui.fragments.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework41.R
import com.example.homework41.databinding.FragmentFormBinding
import com.example.homework41.databinding.FragmentHomeBinding
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormFragment : Fragment(R.layout.fragment_form) {

    private val binding by viewBinding(FragmentFormBinding::bind)
    private val viewModel: FormViewModel by viewModels()
    private val args by navArgs<FormFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).observe(viewLifecycleOwner) {
            Glide.with(ivFullscreen.context)
                .load(it.data.attributes.posterImage.original)
                .into(ivFullscreen)
            tvNameDetail.text = it.data.attributes.titles.enJp
        }
    }
}