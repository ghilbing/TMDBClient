package com.hilbing.tmdbclient.domain.usecase.movie

import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}