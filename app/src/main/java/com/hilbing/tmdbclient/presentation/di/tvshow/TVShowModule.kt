package com.hilbing.tmdbclient.presentation.di.tvshow

import com.hilbing.tmdbclient.data.model.artist.ArtistViewModelFactory
import com.hilbing.tmdbclient.data.model.tvshow.TVShowViewModelFactory
import com.hilbing.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowsUseCase, updateTVShowsUseCase)
    }
}