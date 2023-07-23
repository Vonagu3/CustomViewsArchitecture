package com.example.customviewsarchitecture.content.presentation

import com.example.customviewsarchitecture.main.Communication

interface ContentCommunication: Communication.Mutable<ContentUiState> {
    class Base: Communication.Abstract<ContentUiState>(), ContentCommunication
}