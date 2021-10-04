package com.hilbing.tmdbclient.presentation.di.movie

import com.hilbing.tmdbclient.data.model.artist.ArtistViewModelFactory
import com.hilbing.tmdbclient.data.model.movie.MovieViewModelFactory
import com.hilbing.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import com.hilbing.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}