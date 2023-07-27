package com.example.customviewsarchitecture.settings

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.main.Communication

class SettingViewModel(
    private val communication: SettingCommunication,
    private val settingsChangedCommunication: SettingsChangedCommunication.Update,
    private val loadingModeCache: LoadingModeCache.Mutable,
) : ViewModel(), Communication.Observe<SettingUiState>{

    init {
        communication.map(SettingUiState.Initial(loadingModeCache.isWifiOnly()))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<SettingUiState>) {
        communication.observe(owner, observer)
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
