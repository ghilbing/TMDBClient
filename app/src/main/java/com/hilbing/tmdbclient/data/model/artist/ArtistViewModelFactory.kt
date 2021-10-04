package com.hilbing.tmdbclient.data.model.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hilbing.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}