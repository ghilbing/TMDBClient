package com.hilbing.tmdbclient.presentation

import android.app.Application
import com.hilbing.tmdbclient.BuildConfig
import com.hilbing.tmdbclient.presentation.di.Injector
import com.hilbing.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.hilbing.tmdbclient.presentation.di.core.*
import com.hilbing.tmdbclient.presentation.di.movie.MovieSubComponent
import com.hilbing.tmdbclient.presentation.di.tvshow.TVShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}