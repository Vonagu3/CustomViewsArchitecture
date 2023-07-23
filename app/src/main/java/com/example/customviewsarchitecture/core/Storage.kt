package com.example.customviewsarchitecture.core

import android.content.SharedPreferences

interface Storage {

    fun save(key: String, value: Boolean)

    fun read(key: String, default: Boolean): Boolean

    class Base(private val sharedPreferences: SharedPreferences) : Storage {
        override fun save(key: String, value: Boolean) {
            sharedPreferences.edit().putBoolean(key, value).apply()
        }

        override fun read(key: String, default: Boolean): Boolean {
            return sharedPreferences.getBoolean(key, default)
        }
    }
}