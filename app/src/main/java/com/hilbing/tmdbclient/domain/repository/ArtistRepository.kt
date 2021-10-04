package com.hilbing.tmdbclient.domain.repository

import com.hilbing.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}