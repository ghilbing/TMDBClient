package com.hilbing.tmdbclient.data.repository.tvshow.local

import com.hilbing.tmdbclient.data.db.TVShowDao
import com.hilbing.tmdbclient.data.model.tvshow.TVShow

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao): TVShowLocalDataSource {

    override suspend fun getTVShowsFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        tvShowDao.saveTVShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTVShows()
    }
}