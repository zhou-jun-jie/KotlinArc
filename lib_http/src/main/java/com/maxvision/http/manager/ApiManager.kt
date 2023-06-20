package com.maxvision.http.manager

import com.maxvision.http.api.ApiService

/**
 * user: zjj
 * date: 2023/6/19
 * desc: api管理器
 */
object ApiManager {
    val api by lazy { HttpManager.create(ApiService::class.java) }
}