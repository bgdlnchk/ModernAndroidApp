package em.kh.ua.sqlitec01.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import em.kh.ua.sqlitec01.database.AppDatabase
import em.kh.ua.sqlitec01.ui.PostListViewModel

// Мы не можем создать ViewModel самостоятельно.
// Нам нужна утилита ViewModelProviders, предоставляемая Android
// для создания ViewModels.
// Но ViewModelProviders может только создавать экземпляры ViewModels
// с конструктором без параметров.
// Поэтому, если у нас есть ViewModel с несколькими аргументами,
// нам нужно использовать Factory, которую можем передать
// ViewModelProviders для использования, когда требуется экземпляр нашего ViewModel.

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