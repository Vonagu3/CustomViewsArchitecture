package com.example.customviewsarchitecture.category.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.customviewsarchitecture.category.data.ChosenCategory
import com.example.customviewsarchitecture.category.data.NewsCategories
import com.example.customviewsarchitecture.main.Communication
import com.example.customviewsarchitecture.settings.SettingsChangedCommunication

class ChooseCategoryViewModel(
    private val settingsChangedCommunication: SettingsChangedCommunication.Update,
    private val communication: CategoriesCommunication,
    private val chosenCategory: ChosenCategory.Mutable,
    newsCategories: NewsCategories
): ViewModel(), Communication.Observe<CategoriesUiState>, ChooseCategory {

    init {
        val list = newsCategories.categories(chosenCategory)
        communication.map(CategoriesUiState.Initial(list, this))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<CategoriesUiState>) {
        communication.observe(owner, observer)
    }

    override fun choose(category: String) {
        chosenCategory.save(category)
        communication.map(CategoriesUiState.ChangeChoice(category))
        settingsChangedCommunication.map(true)
    }
}

interface ChooseCategory {
    fun choose(category: String)
}