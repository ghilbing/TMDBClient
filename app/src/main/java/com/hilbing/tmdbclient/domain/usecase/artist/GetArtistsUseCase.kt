package com.hilbing.tmdbclient.domain.usecase.artist

import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}