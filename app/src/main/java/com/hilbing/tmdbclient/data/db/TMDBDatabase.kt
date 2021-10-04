package com.hilbing.tmdbclient.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.data.model.tvshow.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDato(): TVShowDao
}