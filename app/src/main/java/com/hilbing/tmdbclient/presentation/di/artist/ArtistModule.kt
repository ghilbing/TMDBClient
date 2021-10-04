package com.hilbing.tmdbclient.presentation.di.artist

import com.hilbing.tmdbclient.data.model.artist.ArtistViewModelFactory
import com.hilbing.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}