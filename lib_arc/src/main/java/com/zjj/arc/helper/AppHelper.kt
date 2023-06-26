package com.zjj.arc.helper

import android.app.Application

/**
 * user: zjj
 * date: 2023/6/19
 * desc: 提供应用环境
 */
object AppHelper {

    private lateinit var app : Application

    private var isDebug = false

    fun init(application: Application,isDebug : Boolean) {
        app = application
        AppHelper.isDebug = isDebug
    }

    /**
     * 获取全局应用
     */
    fun getApplication() = app

    /**
     * 是否为debug环境
     */
    fun isDebug() = isDebug

}