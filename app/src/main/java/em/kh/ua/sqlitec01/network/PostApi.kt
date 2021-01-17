package em.kh.ua.sqlitec01.network

import em.kh.ua.sqlitec01.database.Post
import io.reactivex.Observable
import retrofit2.http.GET


// интерфейс получения результатов из сети

interface PostApi {

    // Получение списка постов по API.
    // В ReactiveX наблюдатель подписывается на Observable.
    // Затем этот наблюдатель реагирует на любой элемент или последовательность
    // элементов, которые излучает Observable.
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}