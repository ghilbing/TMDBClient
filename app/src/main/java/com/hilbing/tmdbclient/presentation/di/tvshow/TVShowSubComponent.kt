package com.hilbing.tmdbclient.presentation.di.tvshow

import com.hilbing.tmdbclient.presentation.artist.ArtistActivity
import com.hilbing.tmdbclient.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TVShowSubComponent
    }
}