package com.belajar.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.utils.MyTypeConverter

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MyTypeConverter::class)
abstract class MovieCatalogueDatabase : RoomDatabase() {
    abstract fun movieCatalogue(): MovieCatalogueDao

    companion object {
        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: Room.databaseBuilder(
                        context.applicationContext,
                        MovieCatalogueDatabase::class.java,
                        "MovieCatalogue.db"
                    ).build().apply {
                        INSTANCE = this
                    }
            }
    }
}