package com.hilbing.tmdbclient.domain.repository

import com.hilbing.tmdbclient.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}