package com.grayseal.forecastapp.data

import androidx.room.*
import com.grayseal.forecastapp.model.CurrentWeatherObject
import com.grayseal.forecastapp.model.Favourite
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    // Add all queries to interface with the database




    // Current Weather Table
    @Query("SELECT * from current_tbl")
    fun getWeatherObjects(): Flow<List<CurrentWeatherObject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeatherObject(currentWeatherObject: CurrentWeatherObject)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCurrentWeatherObject(currentWeatherObject: CurrentWeatherObject)

    @Query("SELECT * from current_tbl where id =:id")
    suspend fun getWeatherById(id: Int): CurrentWeatherObject
}