package com.zjj.karc

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.zjj.arc.helper.AppHelper
import com.zjj.arc.helper.AppHelper.isDebug
import com.zjj.arc.manager.ActivityManager

/**
 * user: zjj
 * date: 2023/6/24
 * desc: 机器人application
 */
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppHelper.init(this, true)
        registerActivityLifecycle()
        initArouter()
    }

    private fun initArouter() {
        if (isDebug()) {
            // 开启打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        ARouter.init(this)
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