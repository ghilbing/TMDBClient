package com.hilbing.tmdbclient.data.repository.tvshow.cache

import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.data.model.tvshow.TVShow

class TVShowCacheDataSourceImpl: TVShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVSHowsToCache(movies: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(movies)
    }
}