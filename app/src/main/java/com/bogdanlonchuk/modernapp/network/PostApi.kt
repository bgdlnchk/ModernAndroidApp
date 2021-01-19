package com.bogdanlonchuk.modernapp.network

import com.bogdanlonchuk.modernapp.database.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}