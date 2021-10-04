package com.hilbing.tmdbclient.data.repository.tvshow

import com.hilbing.tmdbclient.data.model.tvshow.TVShow
import com.hilbing.tmdbclient.data.repository.tvshow.cache.TVShowCacheDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.local.TVShowLocalDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.remote.TVShowRemoteDataSource
import com.hilbing.tmdbclient.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private var tvShowRemoteDataSource: TVShowRemoteDataSource,
    private var tvShowLocalDataSource: TVShowLocalDataSource,
    private var tvShowCacheDataSource: TVShowCacheDataSource
): TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }


}