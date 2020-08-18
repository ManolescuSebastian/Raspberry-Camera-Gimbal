package com.tekydevelop.android.servocameracontrol.di.components

import android.app.Application
import com.tekydevelop.android.servocameracontrol.SCApplication
import com.tekydevelop.android.servocameracontrol.di.modules.ActivityModule
import com.tekydevelop.android.servocameracontrol.di.modules.NetworkModule
import com.tekydevelop.android.servocameracontrol.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    ActivityModule::class,
    NetworkModule::class,
    ViewModelModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(instance: SCApplication)
}