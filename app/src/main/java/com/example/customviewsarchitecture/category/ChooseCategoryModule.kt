package com.example.customviewsarchitecture.category

import com.example.customviewsarchitecture.category.data.ChosenCategory
import com.example.customviewsarchitecture.category.data.NewsCategories
import com.example.customviewsarchitecture.category.presentation.CategoriesCommunication
import com.example.customviewsarchitecture.category.presentation.ChooseCategoryViewModel
import com.example.customviewsarchitecture.core.Core
import com.example.customviewsarchitecture.core.Module

class ChooseCategoryModule(private val core: Core): Module<ChooseCategoryViewModel> {

    override fun viewModel(): ChooseCategoryViewModel {
        val newsCategories = NewsCategories.Base()
        return ChooseCategoryViewModel(
            core.settingsChangedCommunication(),
            CategoriesCommunication.Base(),
            ChosenCategory.Base(newsCategories, core.storage()),
            newsCategories
        )
    }
}