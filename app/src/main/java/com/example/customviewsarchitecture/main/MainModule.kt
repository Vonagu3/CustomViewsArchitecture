package com.example.customviewsarchitecture.main

import com.example.customviewsarchitecture.core.Module
import com.example.customviewsarchitecture.core.ProvideNavigation

class MainModule(private val core: ProvideNavigation): Module<MainViewModel> {

    override fun viewModel(): MainViewModel {
        return MainViewModel(core.navigation())
    }
}