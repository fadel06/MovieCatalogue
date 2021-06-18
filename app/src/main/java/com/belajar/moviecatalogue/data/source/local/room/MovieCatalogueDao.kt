package com.belajar.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {
    @Query("SELECT * FROM movieEntities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieEntities WHERE id = :movieId")
    fun getMovieById(movieId:Int): LiveData<MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE isFavorite = 1")
    fun getFavMovie(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tvShowEntities")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tvShowEntities WHERE id = :movieId")
    fun getTvShowById(movieId:Int): LiveData<TvShowEntity>

    @Query("SELECT * FROM tvShowEntities WHERE isFavorite = 1")
    fun getFavTvShow(): LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(movies: List<TvShowEntity>)

    @Update
    fun updateTvShow(movie: TvShowEntity)
}