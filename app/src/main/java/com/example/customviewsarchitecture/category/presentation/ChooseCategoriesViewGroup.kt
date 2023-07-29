package com.example.customviewsarchitecture.category.presentation

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.customviewsarchitecture.R
import com.example.customviewsarchitecture.core.ProvideViewModel

class ChooseCategoriesViewGroup: FrameLayout {

    private lateinit var viewModel: ChooseCategoryViewModel

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    init {
        inflate(context, R.layout.choose_categories, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel = (context.applicationContext as ProvideViewModel).viewModel(
            findViewTreeViewModelStoreOwner()!!,
            ChooseCategoryViewModel::class.java
        )

        val linearLayout = findViewById<LinearLayout>(R.id.categoriesContainerLayout)
        viewModel.observe(findViewTreeLifecycleOwner()!!) {
            it.show(linearLayout)
        }
    }
}