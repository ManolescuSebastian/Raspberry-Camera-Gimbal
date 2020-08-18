package com.tekydevelop.android.servocameracontrol.viewmodel

import androidx.lifecycle.ViewModel
import com.tekydevelop.android.servocameracontrol.data.model.ServoResponse
import com.tekydevelop.android.servocameracontrol.network.repo.ServoRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ServoViewModel : ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    private lateinit var servoRepo: ServoRepo

    fun setServoRepo(repository: ServoRepo) {
        servoRepo = repository
    }

    fun moveServo(direction : String) {
        servoRepo.provideServoControl(direction)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeWith(object : DisposableSingleObserver<MutableList<ServoResponse>>() {
                override fun onSuccess(t: MutableList<ServoResponse>) {
                    //create a log to display received data
                }

                override fun onError(e: Throwable) {
                    //display the error in a snack bar
                }
            })!!.let { disposable.add(it) }
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}