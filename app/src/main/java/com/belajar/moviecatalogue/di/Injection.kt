package com.belajar.moviecatalogue.di

import android.content.Context
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource
import com.belajar.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository{
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}