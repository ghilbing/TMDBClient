package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.domain.repository.ArtistRepository
import com.hilbing.tmdbclient.domain.repository.MovieRepository
import com.hilbing.tmdbclient.domain.repository.TVShowRepository
import com.hilbing.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import com.hilbing.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import com.hilbing.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import com.hilbing.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase{
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase{
        return UpdateTVShowsUseCase(tvShowRepository)
    }
}