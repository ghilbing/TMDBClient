package com.hilbing.tmdbclient.data.repository.tvshow.cache

import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.data.model.tvshow.TVShow
import com.hilbing.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVSHowsToCache(tvShows: List<TVShow>)
}