package com.maxvision.karc

import android.app.Application

/**
 * user: zjj
 * date: 2023/5/24
 * desc: 机器人application
 */
class RobotApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initKotlin()
        initTimber()
    }

    // init kotlin
    private fun initKotlin() {

    }

    // init Timber
    private fun initTimber() {

    }

}