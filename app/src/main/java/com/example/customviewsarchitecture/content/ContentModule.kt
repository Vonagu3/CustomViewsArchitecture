package com.example.customviewsarchitecture.content

import com.example.customviewsarchitecture.content.data.BaseContentRepository
import com.example.customviewsarchitecture.content.data.ContentCloudDataSource
import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.content.data.MakeNewsService
import com.example.customviewsarchitecture.content.domain.ContentInteractor
import com.example.customviewsarchitecture.content.domain.HandleError
import com.example.customviewsarchitecture.content.domain.NewsUiMapper
import com.example.customviewsarchitecture.content.presentation.ContentCommunication
import com.example.customviewsarchitecture.content.presentation.ContentViewModel
import com.example.customviewsarchitecture.core.Core
import com.example.customviewsarchitecture.core.DispatchersList
import com.example.customviewsarchitecture.core.Module

class ContentModule(private val core: Core) : Module<ContentViewModel> {
    override fun viewModel(): ContentViewModel {
        val loadingModeCache = LoadingModeCache.Base(core.storage())
        val repository = BaseContentRepository(
            ContentCloudDataSource.Base(MakeNewsService.Base().service()),
            HandleError.Data()
        )
        return ContentViewModel(
            ContentCommunication.Base(),
            DispatchersList.Base(),
            ContentInteractor.Base(
                repository,
                HandleError.Domain(core.manageResource()),
                NewsUiMapper.Base(loadingModeCache)
            ),
            core.settingsChanged(),
            core.navigation()
        )
    }
}