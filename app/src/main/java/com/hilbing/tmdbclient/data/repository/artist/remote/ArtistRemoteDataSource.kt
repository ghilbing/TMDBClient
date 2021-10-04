package com.hilbing.tmdbclient.data.repository.artist.remote

import com.hilbing.tmdbclient.data.model.artist.ArtistList
import com.hilbing.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}