package com.hilbing.tmdbclient.data.repository.artist.local

import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}