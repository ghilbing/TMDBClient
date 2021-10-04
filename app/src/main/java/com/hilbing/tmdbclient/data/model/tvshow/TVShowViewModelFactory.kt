package com.hilbing.tmdbclient.data.model.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hilbing.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}