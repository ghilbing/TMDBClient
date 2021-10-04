package com.hilbing.tmdbclient.data.repository.artist.cache

import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}