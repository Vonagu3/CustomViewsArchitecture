package com.example.customviewsarchitecture.category.data

import android.widget.Button
import com.example.customviewsarchitecture.category.presentation.ChooseCategory
import com.example.customviewsarchitecture.core.Storage

interface NewsCategories {

    fun chosenCategory(key: String, storage: Storage): String

    fun categories(readChosenCategory: ChosenCategory.Read): List<NewsCategory>

    class Base(
        private val list: List<String> = listOf(
            "Apple",
            "Microsoft",
            "Tesla",
            "Russia",
            "Mbappe",
            "Messi",
            "Ronaldo",
            "Macbook",
            "Google Pixel",
            "Galaxy Fold 5"
        )
    ) : NewsCategories {

        override fun chosenCategory(key: String, storage: Storage): String {
            return storage.read(key, if (list.isEmpty()) "" else list[0])
        }

        override fun categories(readChosenCategory: ChosenCategory.Read): List<NewsCategory> {
            val chosenCategory = readChosenCategory.chosenCategory()
            return list.map {
                if (it == chosenCategory)
                    NewsCategory.Chosen(it)
                else
                    NewsCategory.NotChosen(it)
            }
        }
    }
}

interface NewsCategory {
    fun show(button: Button)
    fun choose(chooseCategory: ChooseCategory) = Unit

    abstract class Abstract(
        protected val value: String,
        private val enabled: Boolean
    ) : NewsCategory {

        override fun show(button: Button) {
            button.text = value
            button.isEnabled = enabled
        }
    }

    class Chosen(value: String) : Abstract(value, false)
    class NotChosen(value: String) : Abstract(value, true) {
        override fun choose(chooseCategory: ChooseCategory) {
            chooseCategory.choose(value)
        }
    }
}