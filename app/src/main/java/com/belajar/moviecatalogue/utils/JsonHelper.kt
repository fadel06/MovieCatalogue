package com.belajar.moviecatalogue.utils

import android.content.Context
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.data.ItemEntity
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies() : List<ItemEntity> {
        val movieList = ArrayList<ItemEntity>()

        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("result")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)
                val crewList = ArrayList<CrewEntity>()

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val poster = movie.getString("poster")
                val release = movie.getString("release")
                val rating = movie.getString("rating")
                val trailer = movie.getString("trailer")
                val listCrews = movie.getJSONArray("crews")
                for (indexCrew in 0 until listCrews.length()){
                    val crew = listCrews.getJSONObject(indexCrew)
                    val crewName = crew.getString("crewName")
                    val crewPosition = crew.getString("crewPosition")
                    val crewPhoto = crew.getString("crewPhoto")

                    val crewResult = CrewEntity(crewName, crewPosition, crewPhoto)
                    crewList.add(crewResult)
                }

                val itemResult = ItemEntity(id, title, description, poster,
                    release, rating, trailer, crewList
                )
                movieList.add(itemResult)

            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        return movieList
    }

    fun loadTvShows() : List<ItemEntity> {
        val tvShowList = ArrayList<ItemEntity>()

        try {
            val responseObject = JSONObject(parsingFileToString("tvshows.json").toString())
            val listArray = responseObject.getJSONArray("result")
            for (i in 0 until listArray.length()){
                val crewList = ArrayList<CrewEntity>()
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val poster = movie.getString("poster")
                val release = movie.getString("release")
                val rating = movie.getString("rating")
                val trailer = movie.getString("trailer")
                val listCrews = movie.getJSONArray("crews")
                for (indexCrew in 0 until listCrews.length()){
                    val crew = listCrews.getJSONObject(indexCrew)
                    val crewName = crew.getString("crewName")
                    val crewPosition = crew.getString("crewPosition")
                    val crewPhoto = crew.getString("crewPhoto")

                    val crewResult = CrewEntity(crewName, crewPosition, crewPhoto)
                    crewList.add(crewResult)
                }

                val itemResult = ItemEntity(id, title, description, poster,
                    release, rating, trailer, crewList
                )
                tvShowList.add(itemResult)

            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        return tvShowList
    }

    fun loadMovieDetail(id : Int): ItemEntity?{
        return loadMovies()[id -1]
    }

    fun loadTvShowDetail(id : Int): ItemEntity?{
        return loadTvShows()[id -1]
    }
}