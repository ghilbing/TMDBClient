package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.data.api.TMDBService
import com.hilbing.tmdbclient.data.repository.artist.remote.ArtistRemoteDataSource
import com.hilbing.tmdbclient.data.repository.artist.remote.ArtistRemoteDataSourceImpl
import com.hilbing.tmdbclient.data.repository.movie.remote.MovieRemoteDataSource
import com.hilbing.tmdbclient.data.repository.movie.remote.MovieRemoteDataSourceImpl
import com.hilbing.tmdbclient.data.repository.tvshow.remote.TVShowRemoteDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.remote.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource{
        return TVShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}