package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.hilbing.tmdbclient.data.repository.artist.cache.ArtistCacheDataSource
import com.hilbing.tmdbclient.data.repository.artist.local.ArtistLocalDataSource
import com.hilbing.tmdbclient.data.repository.artist.remote.ArtistRemoteDataSource
import com.hilbing.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.hilbing.tmdbclient.data.repository.movie.cache.MovieCacheDataSource
import com.hilbing.tmdbclient.data.repository.movie.local.MovieLocalDataSource
import com.hilbing.tmdbclient.data.repository.movie.remote.MovieRemoteDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.TVShowRepositoryImpl
import com.hilbing.tmdbclient.data.repository.tvshow.cache.TVShowCacheDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.local.TVShowLocalDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.remote.TVShowRemoteDataSource
import com.hilbing.tmdbclient.domain.repository.ArtistRepository
import com.hilbing.tmdbclient.domain.repository.MovieRepository
import com.hilbing.tmdbclient.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource) : MovieRepository
    {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository
    {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ) : TVShowRepository
    {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}