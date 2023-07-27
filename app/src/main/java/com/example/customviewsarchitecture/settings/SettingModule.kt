package com.example.customviewsarchitecture.settings

import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.core.Core
import com.example.customviewsarchitecture.core.Module

class SettingModule(private val core: Core): Module<SettingViewModel> {
    override fun viewModel(): SettingViewModel {
        return SettingViewModel(
            SettingCommunication.Base(),
            core.settingsChangedCommunication(),
            LoadingModeCache.Base(core.storage())
        )
    }
}