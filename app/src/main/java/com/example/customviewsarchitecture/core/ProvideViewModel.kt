package com.example.customviewsarchitecture.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(owner: ViewModelStoreOwner, className: Class<T>): T
}