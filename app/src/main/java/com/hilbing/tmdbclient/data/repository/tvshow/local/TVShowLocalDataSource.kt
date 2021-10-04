package com.hilbing.tmdbclient.data.repository.tvshow.local

import com.hilbing.tmdbclient.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}