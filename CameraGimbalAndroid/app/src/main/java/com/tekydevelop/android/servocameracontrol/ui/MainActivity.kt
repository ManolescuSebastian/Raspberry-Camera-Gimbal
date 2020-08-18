package com.tekydevelop.android.servocameracontrol.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tekydevelop.android.servocameracontrol.network.repo.ServoRepo
import com.tekydevelop.android.servocameracontrol.viewmodel.ServoViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

import com.tekydevelop.android.servocameracontrol.BuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import com.longdo.mjpegviewer.MjpegView

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var servoRepo: ServoRepo

    private lateinit var servoViewModel: ServoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.tekydevelop.android.servocameracontrol.R.layout.activity_main)
        AndroidInjection.inject(this)

        initData()
        initEvents()
    }

    private fun initData() {
        servoViewModel = ViewModelProviders.of(this).get(ServoViewModel::class.java)
        servoViewModel.setServoRepo(servoRepo)
    }

    private fun initEvents() {
        upButton.setOnClickListener {
            servoViewModel.moveServo("up")
        }

        downButton.setOnClickListener {
            servoViewModel.moveServo("down")
        }

        leftButton.setOnClickListener {
            servoViewModel.moveServo("right")
        }

        rightButton.setOnClickListener {
            servoViewModel.moveServo("left")
        }

        stopButton.setOnClickListener {
            servoViewModel.moveServo("stop")
        }

        retry.setOnClickListener {
            videoStream.mode = MjpegView.MODE_BEST_FIT
            videoStream.isAdjustHeight = true
            videoStream.setUrl("http://192.168.1.9:5020/" + "stream.mjpg")
            videoStream.startStream()
        }
    }
}
