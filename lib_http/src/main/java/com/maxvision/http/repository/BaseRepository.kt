package com.maxvision.http.repository

import com.maxvision.http.constant.TIME_OUT
import com.maxvision.http.error.ApiException
import com.maxvision.http.response.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 基类仓库
 */
open class BaseRepository {

    suspend fun <T> requestResponse(requestCall : suspend ()-> BaseResponse<T>?) : T? {
        val response = withContext(Dispatchers.IO) {
            withTimeout(TIME_OUT) {
                requestCall()
            }
        } ?: return null
        if (response.isFailed()) {
            throw ApiException(response.code,response.msg)
        }
        return response.data
    }

}