package com.maxvision.http.callback

import com.maxvision.arc.utils.TipsToast

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 接口请求错误回调
 */
interface IApiErrorCallback {

    /**
     * 错误回调处理
     */
    fun onError(code: Int?, error: String?) {
        TipsToast.showTips(error)
    }

    /**
     * 登录失效处理
     */
    fun onLoginFail(code: Int?, error: String?) {
        TipsToast.showTips(error)
    }

}