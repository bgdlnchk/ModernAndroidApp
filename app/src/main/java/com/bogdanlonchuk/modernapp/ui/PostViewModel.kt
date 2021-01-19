package com.bogdanlonchuk.modernapp.ui

import androidx.lifecycle.MutableLiveData
import com.bogdanlonchuk.modernapp.base.BaseViewModel
import com.bogdanlonchuk.modernapp.database.Post

class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}