package com.bogdanlonchuk.modernapp.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.bogdanlonchuk.modernapp.database.AppDatabase
import com.bogdanlonchuk.modernapp.ui.PostListViewModel



class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext,
                AppDatabase::class.java,
                "posts.db").build()
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}