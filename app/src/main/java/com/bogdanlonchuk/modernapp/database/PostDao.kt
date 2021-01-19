package com.bogdanlonchuk.modernapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun showAllPosts(): List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}