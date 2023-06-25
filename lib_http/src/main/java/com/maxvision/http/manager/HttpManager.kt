package com.maxvision.http.manager

import com.maxvision.arc.helper.AppHelper
import com.maxvision.http.constant.BASE_URL
import com.maxvision.http.interceptor.CookiesInterceptor
import com.maxvision.http.interceptor.HeaderInterceptor
import com.maxvision.http.interceptor.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

/**
 * user: zjj
 * date: 2023/6/19
 * desc: 网络请求管理类
 */
object HttpManager {

    private val mRetrofit: Retrofit

    /**
     * 初始化retrofit
     */
    init {
        mRetrofit = Retrofit.Builder()
            .client(initOkhttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * 初始化okhttpClient
     */
    private fun initOkhttpClient(): OkHttpClient {
        val build = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
//            .addInterceptor(CookiesInterceptor())
//            .addInterceptor(HeaderInterceptor())
        // 添加日志拦截器
        val logInterceptor = HttpLoggingInterceptor()
        if (AppHelper.isDebug()) {
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
        build.addInterceptor(logInterceptor)
        // 网络状态拦截器
        build.addInterceptor(NetworkInterceptor())
        return build.build()
    }

    /**
     * 获取apiService
     */
    fun <T> create(apiService : Class<T>) : T {
        return mRetrofit.create(apiService)
    }
}