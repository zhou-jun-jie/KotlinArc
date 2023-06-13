package com.maxvision.karc

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Bundle

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