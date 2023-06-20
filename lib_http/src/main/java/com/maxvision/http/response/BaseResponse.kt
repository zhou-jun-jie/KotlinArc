package com.maxvision.http.response

/**
 * user: zjj
 * date: 2023/6/19
 * desc: 通用数据类
 */
data class BaseResponse<out T>(
    val data: T?,
    val code: Int = 200,   // 服务器状态码,200表示成功
    val msg: String = "", // 信息
) {

    /**
     * 判定接口返回是否正常
     */
    fun isFailed(): Boolean {
        return code != 200
    }

}