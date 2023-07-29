package com.example.customviewsarchitecture.category.presentation

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.children
import com.example.customviewsarchitecture.category.data.NewsCategory

interface CategoriesUiState {
    fun show(viewGroup: LinearLayout)

    class Initial(
        private val list: List<NewsCategory>,
        private val chooseCategory: ChooseCategory
        ) : CategoriesUiState {
        override fun show(viewGroup: LinearLayout) {
            viewGroup.removeAllViews()
            list.forEach { newsCategory ->
                val button = Button(viewGroup.context)
                button.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                newsCategory.show(button)
                button.setOnClickListener {
                    newsCategory.choose(chooseCategory)
                }
                viewGroup.addView(button)
            }
        }
    }

    class ChangeChoice(
        private val category: String
    ) : CategoriesUiState {

        override fun show(viewGroup: LinearLayout) {
            viewGroup.children.find { !(it as Button).isEnabled }?.let { chosenButton ->
                chosenButton.isEnabled = true
            }
            viewGroup.children.find { (it as Button).text == category }?.let { newChoiceButton ->
                newChoiceButton.isEnabled = false
            }
        }
    }
}