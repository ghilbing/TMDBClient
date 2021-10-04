package com.hilbing.tmdbclient.domain.repository

import com.hilbing.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}