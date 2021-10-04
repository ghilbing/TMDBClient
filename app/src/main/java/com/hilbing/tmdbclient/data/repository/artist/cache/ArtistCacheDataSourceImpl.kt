package com.hilbing.tmdbclient.data.repository.artist.cache

import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.data.model.movie.Movie

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}