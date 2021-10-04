package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.data.db.ArtistDao
import com.hilbing.tmdbclient.data.db.MovieDao
import com.hilbing.tmdbclient.data.db.TVShowDao
import com.hilbing.tmdbclient.data.repository.artist.local.ArtistLocalDataSource
import com.hilbing.tmdbclient.data.repository.artist.local.ArtistLocalDataSourceImpl
import com.hilbing.tmdbclient.data.repository.movie.local.MovieLocalDataSource
import com.hilbing.tmdbclient.data.repository.movie.local.MovieLocalDataSourceImpl
import com.hilbing.tmdbclient.data.repository.tvshow.local.TVShowLocalDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.local.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource{
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

}