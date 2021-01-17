package em.kh.ua.sqlitec01.injection

import em.kh.ua.sqlitec01.ui.PostListViewModel
import dagger.Component
import javax.inject.Singleton

// Component предоставляющий inject() для ViewModel.

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Внедряет зависимости в PostListViewModel.
     * @param postListViewModel PostListViewModel в которую внедряются
     * зависимости
     */
    fun inject(postListViewModel: PostListViewModel)

    // Строитель для компонента. Компоненты могут иметь один вложенный
    // статический абстрактный класс или интерфейс, аннотированный @ Component.Builder.
    // Если это так, то созданный компонентом компонент будет соответствовать API в типе.
    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}