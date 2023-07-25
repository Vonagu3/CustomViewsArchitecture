package com.example.customviewsarchitecture.settings

import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.core.Core
import com.example.customviewsarchitecture.core.Module
import com.example.customviewsarchitecture.settings.presentation.SettingsCommunication
import com.example.customviewsarchitecture.settings.presentation.SettingsViewModel

class SettingsModule(private val core: Core): Module<SettingsViewModel> {
    override fun viewModel(): SettingsViewModel {
        return SettingsViewModel(
            LoadingModeCache.Base(core.storage()),
            SettingsCommunication.Base(),
            core.settingsChanged()
        )
    }
}