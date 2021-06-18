package com.belajar.moviecatalogue.utils

import androidx.room.TypeConverter
import com.belajar.moviecatalogue.data.source.local.entity.CrewEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyTypeConverter {

    companion object{
        private val gson = Gson()
        @JvmStatic
        @TypeConverter
        fun toJson(crewEntity : List<CrewEntity>):String{
            return gson.toJson(crewEntity)
        }

        @JvmStatic
        @TypeConverter
        fun fromJson(string : String):List<CrewEntity>{
            val type = object : TypeToken<List<CrewEntity>>(){}.type
            return gson.fromJson(string, type)
        }
    }
}