package em.kh.ua.sqlitec01.ui

import androidx.lifecycle.MutableLiveData
import em.kh.ua.sqlitec01.base.BaseViewModel
import em.kh.ua.sqlitec01.database.Post

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