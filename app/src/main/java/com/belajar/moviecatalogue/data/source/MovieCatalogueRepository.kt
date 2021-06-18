package com.belajar.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.belajar.moviecatalogue.data.source.local.LocalDataSource
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.data.source.remote.ApiResponse
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource
import com.belajar.moviecatalogue.utils.AppExecutors
import com.belajar.moviecatalogue.vo.Resource

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieCatalogueDataSource {
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(
                    remoteDataSource,
                    localDataSource,
                    appExecutors
                ).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieEntity>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieEntity>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        id = response.id,
                        title = response.title,
                        description = response.description,
                        poster = response.poster,
                        release = response.release,
                        rating = response.rating,
                        trailer = response.trailer,
                        crewEntity = response.crewEntity,
                        isFavorite = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<MovieEntity>> =
                remoteDataSource.getDetailMovie(movieId)


            override fun saveCallResult(data: MovieEntity) =
                localDataSource.updateMovie(data, false)

        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<List<MovieEntity>> =
        localDataSource.getFavMovie()

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }


    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getAllTvShows()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowEntity>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowEntity>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        id = response.id,
                        title = response.title,
                        description = response.description,
                        poster = response.poster,
                        release = response.release,
                        rating = response.rating,
                        trailer = response.trailer,
                        crewEntity = response.crewEntity,
                        isFavorite = false
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }


    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<TvShowEntity>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: TvShowEntity) =
                localDataSource.updateTvShow(data, false)

        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<List<TvShowEntity>> =
        localDataSource.getFavTvShow()

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }
}