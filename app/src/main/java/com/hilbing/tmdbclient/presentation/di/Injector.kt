package com.hilbing.tmdbclient.presentation.di

import com.hilbing.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.hilbing.tmdbclient.presentation.di.movie.MovieSubComponent
import com.hilbing.tmdbclient.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTVShowSubComponent(): TVShowSubComponent
}