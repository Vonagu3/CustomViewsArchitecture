package com.example.customviewsarchitecture.content.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewsarchitecture.R
import com.example.customviewsarchitecture.core.ProvideViewModel

class ContentFragment: Fragment() {

    private lateinit var viewModel: ContentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(this, ContentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.content_fragment, container, false)


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

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = NewsAdapter()

        recyclerView.adapter = adapter

        viewModel.observe(this) {
            it.showChoice(wifiOnlyRadioButton, alsoMobileSourceRadioButton)
            it.showNews(adapter)
        }

        viewModel.init(savedInstanceState == null)

    }
}