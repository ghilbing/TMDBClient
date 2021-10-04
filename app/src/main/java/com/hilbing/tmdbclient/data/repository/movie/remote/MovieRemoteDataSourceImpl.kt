package com.hilbing.tmdbclient.data.repository.movie.remote

import com.hilbing.tmdbclient.data.api.TMDBService
import com.hilbing.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}