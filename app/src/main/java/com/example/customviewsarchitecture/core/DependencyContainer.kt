package com.example.customviewsarchitecture.core

import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.content.ContentModule
import com.example.customviewsarchitecture.content.presentation.ContentViewModel
import com.example.customviewsarchitecture.main.MainModule
import com.example.customviewsarchitecture.main.MainViewModel
import com.example.customviewsarchitecture.settings.SettingsModule
import com.example.customviewsarchitecture.settings.presentation.SettingsViewModel

interface DependencyContainer {

    fun module(className: Class<out ViewModel>): Module<out ViewModel>

    class Error : DependencyContainer {
        override fun module(className: Class<out ViewModel>): Module<out ViewModel> {
            throw IllegalArgumentException("unknown classname $className")
        }
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {
        override fun module(className: Class<out ViewModel>): Module<out ViewModel> =
            when (className) {
                MainViewModel::class.java -> MainModule(core)
                ContentViewModel::class.java -> ContentModule(core)
                SettingsViewModel::class.java -> SettingsModule(core)
                else -> dependencyContainer.module(className)
            }
    }
}