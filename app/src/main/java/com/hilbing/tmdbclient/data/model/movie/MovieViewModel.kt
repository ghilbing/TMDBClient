package com.hilbing.tmdbclient.data.model.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hilbing.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import com.hilbing.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}