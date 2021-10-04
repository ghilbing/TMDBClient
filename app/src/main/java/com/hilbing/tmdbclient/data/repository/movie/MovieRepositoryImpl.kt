package com.hilbing.tmdbclient.data.repository.movie

import android.util.Log
import com.hilbing.tmdbclient.data.model.movie.Movie
import com.hilbing.tmdbclient.data.model.movie.MovieList
import com.hilbing.tmdbclient.data.repository.movie.cache.MovieCacheDataSource
import com.hilbing.tmdbclient.data.repository.movie.local.MovieLocalDataSource
import com.hilbing.tmdbclient.data.repository.movie.remote.MovieRemoteDataSource
import com.hilbing.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.results
            }

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (exception: Exception){
            Log.i("TAG", "getMoviesFromAPI: " + exception.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}