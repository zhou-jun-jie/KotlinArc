package com.maxvision.http.interceptor

import com.maxvision.arc.helper.AppHelper
import com.maxvision.arc.utils.NetworkUtil
import com.maxvision.http.error.ERROR
import com.maxvision.http.error.NoNetWorkException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * user: zjj
 * date: 2023/6/19
 * desc: 网络状态拦截器
 */
class NetworkInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        if (NetworkUtil.isConnected(AppHelper.getApplication())) {
            val request = chain.request()
            return chain.proceed(request)
        } else {
            throw NoNetWorkException(ERROR.NETWORD_ERROR)
        }
    }
}