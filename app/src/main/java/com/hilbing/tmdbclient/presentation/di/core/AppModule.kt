package com.hilbing.tmdbclient.presentation.di.core

import android.content.Context
import com.hilbing.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.hilbing.tmdbclient.presentation.di.movie.MovieScope
import com.hilbing.tmdbclient.presentation.di.movie.MovieSubComponent
import com.hilbing.tmdbclient.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TVShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }

}