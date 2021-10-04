package com.hilbing.tmdbclient.data.repository.movie.remote

import com.hilbing.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}