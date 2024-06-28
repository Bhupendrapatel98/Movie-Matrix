package com.app.moviematrix.data.local.database

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.app.moviematrix.data.model.trending.KnownFor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromKnownForList(knownFor: List<KnownFor>): String? {
        val type = object : TypeToken<List<KnownFor>>() {}.type
        return gson.toJson(knownFor, type)
    }

    @TypeConverter
    fun toKnownForList(knownForString: String): List<KnownFor> {
        val type = object : TypeToken<List<KnownFor>>() {}.type
        return gson.fromJson(knownForString, type)
    }
}