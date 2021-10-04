package com.hilbing.tmdbclient.data.repository.artist.remote

import com.hilbing.tmdbclient.data.api.TMDBService
import com.hilbing.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}