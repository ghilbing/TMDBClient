package com.hilbing.tmdbclient.presentation.di.core

import com.hilbing.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.hilbing.tmdbclient.presentation.di.movie.MovieSubComponent
import com.hilbing.tmdbclient.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DatabaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TVShowSubComponent.Factory

}