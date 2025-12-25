package com.ravi2411sharma.facerecognition.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ResidentEntity::class], version = 1, exportSchema = false)
abstract class ResidentDatabase : RoomDatabase() {
    abstract fun residentDao(): ResidentDao

    companion object {
        @Volatile
        private var instance: ResidentDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): ResidentDatabase {
            if (instance == null) {
                synchronized(LOCK) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            ResidentDatabase::class.java,
                            "resident_database"
                        ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            synchronized(LOCK) {
                instance?.close()
                instance = null
            }
        }
    }
}
