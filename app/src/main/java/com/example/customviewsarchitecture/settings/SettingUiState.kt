package com.example.customviewsarchitecture.settings

import android.widget.RadioButton

interface SettingUiState {

    fun showChoice(wifiOnlyRadioButton: RadioButton, alsoMobileRadioButton: RadioButton)

    class Initial(private val wifiOnlyChosen: Boolean): SettingUiState {
        override fun showChoice(
            wifiOnlyRadioButton: RadioButton,
            alsoMobileRadioButton: RadioButton
        ) {
            wifiOnlyRadioButton.isChecked = wifiOnlyChosen
            alsoMobileRadioButton.isChecked = !wifiOnlyChosen
        }
    }


}