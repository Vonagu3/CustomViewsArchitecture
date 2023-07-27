package com.example.customviewsarchitecture.settings

import com.example.customviewsarchitecture.main.Communication

interface SettingsChangedCommunication {
    interface Update: Communication.Update<Boolean>
    interface Observe: Communication.Observe<Boolean>
    interface Mutable: Update, Observe

    class Base: Communication.Abstract<Boolean>(), Mutable
}