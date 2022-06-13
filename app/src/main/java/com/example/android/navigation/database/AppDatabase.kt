package com.example.android.navigation.database
import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.navigation.database.model.Tasks

/**
 * Databaza pre tabulkty: Tasks
 */
@Database(entities = [Tasks::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    //metoda vracia appDatabaseDao
    abstract fun appDatabaseDao(): AppDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Application): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "tasks_database"
                    )
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
