package com.matech.kotlindsl.data.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.matech.kotlindsl.data.database.dao.MoviesDao
import com.matech.kotlindsl.data.database.entities.Converter
import com.matech.kotlindsl.data.database.entities.MoviesEntities


@Database(
    entities = [MoviesEntities::class
    ], version = 0, exportSchema = false
)

//@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao() : MoviesDao
}