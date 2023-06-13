package com.maxvision.arc.manager

import android.app.Activity
import android.app.Application

/**
 * user: zjj
 * date: 2023/5/26
 * desc: 描述
 */
class ActivityManager {

    private val tasks = mutableListOf<Activity>()

    fun push(activity: Activity) {
        tasks.add(activity)
    }

    fun pop(activity: Activity) {
        tasks.remove(activity)
    }

    fun top() : Activity {
       return tasks.last()
    }

    fun finishAllActivity(callback :(()-> Unit)? = null) {
        callback?.invoke()
    }



}