package com.example.recipesapp.data.database

import android.util.Log
import androidx.room.TypeConverter

class StringListTypeConvertor {

    @TypeConverter
    fun fromListStringToString(stringList: List<String>): String = stringList.toString()

    @TypeConverter
    fun toListStringFromString(stringList: String): List<String> {
        val result = ArrayList<String>()
        val split = stringList.replace("[", "").replace("]", "").replace(" ", "").split(",")
        for (n in split) {
            try {
                result.add(n)
            } catch (e: Exception) {
                Log.d("StringListTypeConvertor", "Can not be converted")
            }
        }
        return result
    }
}