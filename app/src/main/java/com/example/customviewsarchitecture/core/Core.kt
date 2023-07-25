package com.example.customviewsarchitecture.core

import android.content.Context
import com.example.customviewsarchitecture.main.NavigationCommunication
import com.example.customviewsarchitecture.settings.presentation.SettingsChangedCommunication

class Core(context: Context) : ProvideNavigation, ProvideStorage, ProvideManageResource, ProvideSettingsChangedCommunication {

    private val settingsChanged = SettingsChangedCommunication.Base()
    private val manageResource = ManageResource.Base(context)
    private val navigation = NavigationCommunication.Base()
    private val storage =
        Storage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))

    override fun navigation(): NavigationCommunication.Mutable {
        return navigation
    }

    override fun storage(): Storage {
        return storage
    }

    override fun manageResource(): ManageResource {
        return manageResource
    }

    override fun settingsChanged(): SettingsChangedCommunication.Mutable {
        return settingsChanged
    }

    companion object {
        private const val STORAGE_NAME = "NEWS APP DATA"
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
    fun settingsChanged(): SettingsChangedCommunication.Mutable
}