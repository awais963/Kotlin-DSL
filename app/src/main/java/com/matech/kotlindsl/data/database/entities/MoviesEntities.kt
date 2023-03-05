package com.matech.kotlindsl.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoviesEntities (
    @PrimaryKey
    @ColumnInfo(name = "movie_id" )
    val id: Int,
    @ColumnInfo(name = "actor" )
    val actors: String,
    @ColumnInfo(name = "director" )
    val director: String
  ,
    @ColumnInfo(name = "plot" )
    val plot: String,
    @ColumnInfo(name = "poster_url" )
    val posterUrl: String,
    @ColumnInfo(name = "runtime" )
    val runtime: String,
    @ColumnInfo(name = "title" )
    val title: String,
    @ColumnInfo(name = "year" )
    val year: String
        )