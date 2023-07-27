package com.example.customviewsarchitecture.settings

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RadioButton
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.customviewsarchitecture.R
import com.example.customviewsarchitecture.core.ProvideViewModel

class SettingsView: FrameLayout {

    private lateinit var viewModel: SettingViewModel

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    init {
        inflate(context, R.layout.settings_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel = (context.applicationContext as ProvideViewModel).viewModel(
            findViewTreeViewModelStoreOwner()!!,
            SettingViewModel::class.java
        )

        val wifiOnlyRadioButton: RadioButton = findViewById(R.id.wifiOnlyRadioButton)
        val alsoMobileSourceRadioButton: RadioButton = findViewById(R.id.alsoMobileSourceRadioButton)

        wifiOnlyRadioButton.setOnClickListener {
            viewModel.chooseWifiOnly()
        }

        alsoMobileSourceRadioButton.setOnClickListener {
            viewModel.chooseAlsoMobile()
        }

        viewModel.observe(findViewTreeLifecycleOwner()!!) {
            it.showChoice(wifiOnlyRadioButton, alsoMobileSourceRadioButton)
        }
    }
}