package com.bogdanlonchuk.modernapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(val userId: Int,
                @PrimaryKey
                val id: Int,
                val title: String,
                val body: String)