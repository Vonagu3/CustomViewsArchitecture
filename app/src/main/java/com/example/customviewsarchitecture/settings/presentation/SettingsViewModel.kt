package com.example.customviewsarchitecture.settings.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.core.Init
import com.example.customviewsarchitecture.main.Communication

class SettingsViewModel(
    private val loadingModeCache: LoadingModeCache.Mutable,
    private val communication: SettingsCommunication,
    private val settingsChangedCommunication: SettingsChangedCommunication.Update
) : ViewModel(), Init, Communication.Observe<SettingsUiState> {

    override fun observe(owner: LifecycleOwner, observer: Observer<SettingsUiState>) {
        communication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        communication.map(SettingsUiState.Initial(loadingModeCache.isWifiOnly()))
    }

    fun chooseWifiOnly() {
        loadingModeCache.save(true)
        settingsChangedCommunication.map(true)
    }

    fun chooseAlsoMobile() {
        loadingModeCache.save(false)
        settingsChangedCommunication.map(true)
    }
}

