package com.example.homework41.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>(@LayoutRes layoutId: Int) :
    Fragment(
        layoutId
    ) {
    protected abstract val binding: Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        launchObservers()

    }

    protected open fun initialize() {
    }

    protected open fun setupViews() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {

    }

    protected open fun launchObservers() {

    }
}