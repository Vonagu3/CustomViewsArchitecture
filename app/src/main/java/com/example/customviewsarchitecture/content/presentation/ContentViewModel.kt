package com.example.customviewsarchitecture.content.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.content.domain.ContentInteractor
import com.example.customviewsarchitecture.core.DispatchersList
import com.example.customviewsarchitecture.core.Init
import com.example.customviewsarchitecture.main.Communication
import com.example.customviewsarchitecture.settings.SettingsChangedCommunication
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val settingsChangedCommunication: SettingsChangedCommunication.Observe,
    private val communication: ContentCommunication,
    private val dispatchersList: DispatchersList,
    private val interactor: ContentInteractor
) : ViewModel(), Communication.Observe<ContentUiState>, Init, Load {

    override fun observe(owner: LifecycleOwner, observer: Observer<ContentUiState>) {
        communication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        if (firstRun) {
            load()
        }
    }

    override fun load() {
        viewModelScope.launch(dispatchersList.io()) {
            val result = interactor.data()
            withContext(dispatchersList.ui()) {
                result.map(communication)
            }
        }
    }

    fun observeSettingChanged(owner: LifecycleOwner, observer: Observer<Boolean>) {
        settingsChangedCommunication.observe(owner, observer)
    }
}

interface Load {
    fun load()
}