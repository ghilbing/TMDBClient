package com.hilbing.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.hilbing.tmdbclient.data.db.ArtistDao
import com.hilbing.tmdbclient.data.db.MovieDao
import com.hilbing.tmdbclient.data.db.TMDBDatabase
import com.hilbing.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase): TVShowDao{
        return tmdbDatabase.tvShowDato()
    }

}