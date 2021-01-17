package em.kh.ua.sqlitec01.injection

import em.kh.ua.sqlitec01.network.PostApi
import em.kh.ua.sqlitec01.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

// Module обеспечивает требуемые зависимости для сети

@Module
@Suppress("unused")
object NetworkModule {
    /**
     * Предоставление PostApi.
     * @param retrofit объект Retrofit, используемый для создания экземпляра PostApi
     * @return PostApi применение.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    /**
     * Предоставление объекта Retrofit
     * @return Retrofit объект
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                    .createWithScheduler(Schedulers.io()))
                .build()
    }
}