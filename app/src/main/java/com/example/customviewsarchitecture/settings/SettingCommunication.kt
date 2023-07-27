package com.example.customviewsarchitecture.settings

import com.example.customviewsarchitecture.main.Communication

interface SettingCommunication : Communication.Mutable<SettingUiState> {
    class Base: Communication.Abstract<SettingUiState>(), SettingCommunication
}