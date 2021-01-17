package em.kh.ua.sqlitec01.base

import androidx.lifecycle.ViewModel
import em.kh.ua.sqlitec01.injection.NetworkModule
import em.kh.ua.sqlitec01.injection.DaggerViewModelInjector
import em.kh.ua.sqlitec01.injection.ViewModelInjector
import em.kh.ua.sqlitec01.ui.PostListViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    // Инъекция необходимых зависимостей
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}