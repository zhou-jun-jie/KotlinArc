package com.maxvision.http.flow

import com.maxvision.http.constant.TIME_OUT
import com.maxvision.http.error.ApiException
import com.maxvision.http.error.ExceptionHandler
import com.maxvision.http.response.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withTimeout

/**
 * user: zjj
 * date: 2023/6/20
 * desc: flow请求拓展
 */

suspend fun <T> requestFlow(
    errorBlock: ((Int?, String?) -> Unit)? = null,
    requestCall: suspend () -> BaseResponse<T>?,
    showLoading: ((Boolean) -> Unit)? = null
) : T?{
    var data : T? = null
    val flow = requestFlowResponse(errorBlock,requestCall,showLoading)
    //7.调用collect获取emit()回调的结果，就是请求最后的结果
    flow.collect {
        data = it?.data
    }
    return data
}


/**
 * 通过flow执行请求，需要在协程作用域中执行
 * @param errorBlock 错误回调
 * @param requestCall 执行的请求
 * @param showLoading 开启和关闭加载框
 * @return Flow<BaseResponse<T>>
 */
suspend fun <T> requestFlowResponse(
    errorBlock: ((Int?, String?) -> Unit)? = null,
    requestCall: suspend () -> BaseResponse<T>?,
    showLoading: ((Boolean) -> Unit)? = null
): Flow<BaseResponse<T>?> {
    // 1. 执行请求
    val flow = flow {
        val response = withTimeout(TIME_OUT) {
            requestCall()
        }
        if (response?.isFailed() == true) {
            throw ApiException(response.code,response.msg)
        }
        /**
         * 2. 发送网络请求结果回调
         * 这里必须先发送网络,确定response的实体类泛型
         */
        emit(response)
        // 3. 指定运行的线程
    }.flowOn(Dispatchers.IO)
        .onStart {
            // 4. 请求开始,展示加载框
            showLoading?.invoke(true)
        }
        .catch { e->
            e.printStackTrace()
            // 5. 捕获异常
            val exception = ExceptionHandler.handleException(e)
            errorBlock?.invoke(exception.errCode,exception.errMsg)
        }
        // 6. 请求完成,包括成功和失败
        .onCompletion {
            showLoading?.invoke(false)
        }
    return flow
}