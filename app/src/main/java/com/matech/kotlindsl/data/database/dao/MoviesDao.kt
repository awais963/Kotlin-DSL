package com.matech.kotlindsl.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.matech.kotlindsl.data.database.entities.MoviesEntities

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies:  List<MoviesEntities>)
}