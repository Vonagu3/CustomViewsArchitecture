package com.example.customviewsarchitecture.core

import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.category.ChooseCategoryModule
import com.example.customviewsarchitecture.category.presentation.ChooseCategoryViewModel
import com.example.customviewsarchitecture.content.ContentModule
import com.example.customviewsarchitecture.content.presentation.ContentViewModel
import com.example.customviewsarchitecture.main.MainModule
import com.example.customviewsarchitecture.main.MainViewModel
import com.example.customviewsarchitecture.settings.SettingModule
import com.example.customviewsarchitecture.settings.SettingViewModel

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
                SettingViewModel::class.java -> SettingModule(core)
                ChooseCategoryViewModel::class.java -> ChooseCategoryModule(core)
                else -> dependencyContainer.module(className)
            }
    }
}