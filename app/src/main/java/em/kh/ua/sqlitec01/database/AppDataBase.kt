package em.kh.ua.sqlitec01.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Post::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}