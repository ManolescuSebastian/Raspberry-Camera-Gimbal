package com.tekydevelop.android.servocameracontrol.network.repo

import com.tekydevelop.android.servocameracontrol.data.model.ServoResponse
import com.tekydevelop.android.servocameracontrol.data.services.DeviceControlService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServoRepo @Inject constructor(private val deviceControlService: DeviceControlService) {

    //The repo was not not needed here but I've added it in case we want to save the data to a database in the near future

    fun provideServoControl(direction: String): Single<MutableList<ServoResponse>>? {
        return deviceControlService.servoControl(direction)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> response }
    }
}