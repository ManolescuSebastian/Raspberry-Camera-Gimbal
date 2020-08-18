package com.tekydevelop.android.servocameracontrol.di.modules

import androidx.lifecycle.ViewModelProvider
import com.tekydevelop.android.servocameracontrol.di.InjectingViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: InjectingViewModelFactory): ViewModelProvider.Factory
}