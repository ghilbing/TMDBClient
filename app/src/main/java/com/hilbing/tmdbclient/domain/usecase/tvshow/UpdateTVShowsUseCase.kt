package com.hilbing.tmdbclient.domain.usecase.tvshow

import com.hilbing.tmdbclient.data.model.tvshow.TVShow
import com.hilbing.tmdbclient.domain.repository.TVShowRepository

class UpdateTVShowsUseCase (private val tvShowRepository: TVShowRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.updateTVShows()
}