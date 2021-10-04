package com.hilbing.tmdbclient.data.model.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hilbing.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModel() {

    fun getTVShows() = liveData {
        val tvShowList = getTVShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowsUseCase.execute()
        emit(tvShowList)
    }
}