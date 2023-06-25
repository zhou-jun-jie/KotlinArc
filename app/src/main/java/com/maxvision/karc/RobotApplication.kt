package com.maxvision.karc

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.maxvision.arc.helper.AppHelper
import com.maxvision.arc.manager.ActivityManager
import com.maxvision.arc.utils.TipsToast

/**
 * user: zjj
 * date: 2023/5/24
 * desc: 机器人application
 */
class RobotApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        AppHelper.init(this,true)
        registerActivityLifecycle()
        TipsToast.init(this)
    }

    /**
     * 注册Activity生命周期监听
     */
    private fun registerActivityLifecycle() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                ActivityManager.remove(activity)
            }

            override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, p1: Bundle?) {
                ActivityManager.add(activity)
            }

            override fun onActivityResumed(activity: Activity) {
            }
        })
    }

}