package com.example.customviewsarchitecture.core

import android.content.Context
import com.example.customviewsarchitecture.main.NavigationCommunication
import com.example.customviewsarchitecture.settings.SettingsChangedCommunication

class Core(context: Context) : ProvideNavigation, ProvideStorage, ProvideManageResource, ProvideSettingsChangedCommunication {

    private val manageResource = ManageResource.Base(context)
    private val navigation = NavigationCommunication.Base()
    private val storage =
        Storage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))
    private val settingsChangedCommunication: SettingsChangedCommunication.Mutable = SettingsChangedCommunication.Base()

    override fun navigation(): NavigationCommunication.Mutable {
        return navigation
    }

    override fun storage(): Storage {
        return storage
    }

    override fun manageResource(): ManageResource {
        return manageResource
    }

    companion object {
        private const val STORAGE_NAME = "NEWS APP DATA"
    }

    override fun settingsChangedCommunication(): SettingsChangedCommunication.Mutable {
        return settingsChangedCommunication
    }
}

interface ProvideNavigation {

    fun navigation(): NavigationCommunication.Mutable
}

interface ProvideStorage {

    fun storage(): Storage
}

interface ProvideManageResource {

    fun manageResource(): ManageResource
}

interface ProvideSettingsChangedCommunication {

    fun settingsChangedCommunication(): SettingsChangedCommunication.Mutable
}
