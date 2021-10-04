package com.hilbing.tmdbclient.domain.usecase.artist

import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase (private val artistRepository: ArtistRepository){
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}