package com.tekydevelop.android.servocameracontrol.di.modules

import android.provider.SyncStateContract
import androidx.annotation.NonNull
import com.tekydevelop.android.servocameracontrol.BuildConfig
import com.tekydevelop.android.servocameracontrol.data.services.DeviceControlService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.DeviceIP)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDeviceControl(@NonNull retrofit: Retrofit): DeviceControlService {
        return retrofit.create(DeviceControlService::class.java)
    }



}