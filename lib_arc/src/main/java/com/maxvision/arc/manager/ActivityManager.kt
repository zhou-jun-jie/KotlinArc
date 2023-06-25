package com.maxvision.arc.manager

import android.app.Activity

/**
 * user: zjj
 * date: 2023/5/26
 * desc: activity管理类
 */
object ActivityManager {

    private val tasks = mutableListOf<Activity>()

    fun add(activity: Activity) {
        tasks.add(activity)
    }

    fun remove(activity: Activity) {
        tasks.remove(activity)
    }

    fun top() : Activity {
       return tasks.last()
    }

    fun finishAllActivity(callback :(()-> Unit)? = null) {
        callback?.invoke()
    }



}