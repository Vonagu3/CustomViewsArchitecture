package com.example.customviewsarchitecture.core

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class App: Application(), ProvideViewModel {

    private lateinit var viewModelFactory: ViewModelsFactory

    override fun onCreate() {
        super.onCreate()
        viewModelFactory = ViewModelsFactory(DependencyContainer.Base(Core(this)))
    }

    override fun <T : ViewModel> viewModel(owner: ViewModelStoreOwner, className: Class<T>): T {
        return ViewModelProvider(owner, viewModelFactory)[className]
    }
}