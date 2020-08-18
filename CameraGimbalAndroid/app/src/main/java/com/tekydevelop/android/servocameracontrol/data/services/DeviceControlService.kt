package com.tekydevelop.android.servocameracontrol.data.services

import com.tekydevelop.android.servocameracontrol.data.model.ServoResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DeviceControlService {

    @GET("api/servo")
    fun servoControl(@Query("move") name: String): Single<MutableList<ServoResponse>>
}