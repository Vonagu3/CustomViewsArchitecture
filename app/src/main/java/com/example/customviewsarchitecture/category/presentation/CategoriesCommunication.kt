package com.example.customviewsarchitecture.category.presentation

import com.example.customviewsarchitecture.main.Communication

interface CategoriesCommunication: Communication.Mutable<CategoriesUiState> {
    class Base  :Communication.Abstract<CategoriesUiState>(), CategoriesCommunication
}