package com.example.customviewsarchitecture.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.content.presentation.ContentScreen
import com.example.customviewsarchitecture.core.Init

class MainViewModel(
    private val communication: NavigationCommunication.Mutable
): ViewModel(), Communication.Observe<Screen>, Init {

    override fun observe(owner: LifecycleOwner, observer: Observer<Screen>) {
        communication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        if (firstRun) {
            communication.map(ContentScreen())
        }
    }
}