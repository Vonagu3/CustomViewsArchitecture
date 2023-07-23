package com.example.customviewsarchitecture.content.data

import com.example.customviewsarchitecture.core.Storage

interface LoadingModeCache {

    interface Save {

        fun save(wifiOnly: Boolean)
    }

    interface Read {

        fun isWifiOnly(): Boolean
    }

    interface Mutable : Save, Read

    class Base(
        private val storage: Storage,
        private val key: String = "isWifiOnlyChosen"
    ) : Mutable {

        override fun save(wifiOnly: Boolean) {
            storage.save(key, wifiOnly)
        }

        override fun isWifiOnly() = storage.read(key, true)
    }
}