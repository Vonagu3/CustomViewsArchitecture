package com.example.customviewsarchitecture.content.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        view.findViewById<View>(R.id.settingsButton).setOnClickListener {
            viewModel.showSettings()
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = NewsAdapter()

        recyclerView.adapter = adapter

        viewModel.observe(this) {
            it.showNews(adapter)
        }

        viewModel.observeSettingsChanged(this) {
            viewModel.load()
        }

        viewModel.init(savedInstanceState == null)

    }
}