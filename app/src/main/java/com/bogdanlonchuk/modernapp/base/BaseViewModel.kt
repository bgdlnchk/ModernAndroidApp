package com.bogdanlonchuk.modernapp.base

import androidx.lifecycle.ViewModel
import com.bogdanlonchuk.modernapp.injection.NetworkModule
import com.bogdanlonchuk.modernapp.injection.DaggerViewModelInjector
import com.bogdanlonchuk.modernapp.injection.ViewModelInjector
import com.bogdanlonchuk.modernapp.ui.PostListViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}