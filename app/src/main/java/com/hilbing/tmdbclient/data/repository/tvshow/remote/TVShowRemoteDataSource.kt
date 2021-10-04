package com.hilbing.tmdbclient.data.repository.tvshow.remote

import com.hilbing.tmdbclient.data.model.movie.MovieList
import com.hilbing.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}