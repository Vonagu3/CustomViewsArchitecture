package com.example.customviewsarchitecture.settings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.customviewsarchitecture.R
import com.example.customviewsarchitecture.core.ProvideViewModel

class SettingsFragment: Fragment() {

    private lateinit var viewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(this, SettingsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wifiOnlyRadioButton: RadioButton = view.findViewById(R.id.wifiOnlyRadioButton)
        val alsoMobileSourceRadioButton: RadioButton = view.findViewById(R.id.alsoMobileSourceRadioButton)

        wifiOnlyRadioButton.setOnClickListener {
            viewModel.chooseWifiOnly()
        }

        alsoMobileSourceRadioButton.setOnClickListener {
            viewModel.chooseAlsoMobile()
        }

        viewModel.observe(this) {
            it.showChoice(wifiOnlyRadioButton, alsoMobileSourceRadioButton)
        }

        viewModel.init(savedInstanceState == null)
    }

}