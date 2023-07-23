package com.example.customviewsarchitecture.core

import androidx.lifecycle.ViewModel

interface Module<T: ViewModel> {

    fun viewModel(): T
}