package com.hilbing.tmdbclient.data.repository.artist

import android.graphics.ImageDecoder
import android.util.Log
import com.hilbing.tmdbclient.data.model.artist.Artist
import com.hilbing.tmdbclient.data.model.artist.ArtistList
import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.data.model.movie.MovieList
import com.hilbing.tmdbclient.data.repository.artist.cache.ArtistCacheDataSource
import com.hilbing.tmdbclient.data.repository.artist.local.ArtistLocalDataSource
import com.hilbing.tmdbclient.data.repository.artist.remote.ArtistRemoteDataSource
import com.hilbing.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        if(artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        if(artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }


}