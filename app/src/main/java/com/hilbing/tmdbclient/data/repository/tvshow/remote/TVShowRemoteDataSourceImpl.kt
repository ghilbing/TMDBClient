package com.hilbing.tmdbclient.data.repository.tvshow.remote

import com.hilbing.tmdbclient.data.api.TMDBService
import com.hilbing.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)
}