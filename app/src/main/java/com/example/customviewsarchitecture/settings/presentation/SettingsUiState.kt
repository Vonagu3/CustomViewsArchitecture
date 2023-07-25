package com.example.customviewsarchitecture.settings.presentation

import android.widget.RadioButton

interface SettingsUiState {

    fun showChoice(wifiOnlyRadioButton: RadioButton, alsoMobileRadioButton: RadioButton) = Unit

    class Initial(private val wifiOnlyChosen: Boolean) : SettingsUiState {
        override fun showChoice(
            wifiOnlyRadioButton: RadioButton,
            alsoMobileRadioButton: RadioButton
        ) {
            wifiOnlyRadioButton.isChecked = wifiOnlyChosen
            alsoMobileRadioButton.isChecked = !wifiOnlyChosen
        }
    }
}