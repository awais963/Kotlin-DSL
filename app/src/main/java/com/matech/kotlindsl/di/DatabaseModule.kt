package com.matech.kotlindsl.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.matech.kotlindsl.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun getDataBase(@ApplicationContext context: Context): AppDatabase {

        val REMOVE_MOVIES_TABLE: Migration = object : Migration(0, 1) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Speciality")
            }
        }



//        val DELETE_BLOG_ITEM_TABLE: Migration = object : Migration(17, 18) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("DROP TABLE BlogItem")
//            }
//        }


        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "mvvm_template_db").
            fallbackToDestructiveMigration().build()
//            .addMigrations(REMOVE_ALL_SPECIALITIES)
        //       .addMigrations(DELETE_BLOG_ITEM_TABL
        //Add this line if destruction of old data base is required   .fallbackToDestructiveMigration()


    }

}