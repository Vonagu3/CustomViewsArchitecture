package com.example.customviewsarchitecture.settings.presentation

import com.example.customviewsarchitecture.main.Communication

interface SettingsCommunication: Communication.Mutable<SettingsUiState> {
    class Base: Communication.Abstract<SettingsUiState>(), SettingsCommunication
}