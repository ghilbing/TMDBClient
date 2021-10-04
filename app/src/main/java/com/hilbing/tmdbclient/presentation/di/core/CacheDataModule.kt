package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.data.repository.artist.cache.ArtistCacheDataSource
import com.hilbing.tmdbclient.data.repository.artist.cache.ArtistCacheDataSourceImpl
import com.hilbing.tmdbclient.data.repository.movie.cache.MovieCacheDataSource
import com.hilbing.tmdbclient.data.repository.movie.cache.MovieCacheDataSourceImpl
import com.hilbing.tmdbclient.data.repository.tvshow.cache.TVShowCacheDataSource
import com.hilbing.tmdbclient.data.repository.tvshow.cache.TVShowCacheDataSourceImpl
import com.hilbing.tmdbclient.data.repository.tvshow.local.TVShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }


}