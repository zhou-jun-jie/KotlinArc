package com.maxvision.arc.utils

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.maxvision.arc.widget.LoadingView

/**
 * user: zjj
 * date: 2023/6/2
 * desc: 加载框工具类
 */
class LoadingUtils(private val mContext: Context) {

    private var loadView: LoadingView? = null

    // 显示弹窗
    fun showLoading(txt : String?) {
        if (loadView == null) {
            loadView = LoadingView(mContext)
        }
        if (loadView?.isShowing == true) {
            loadView?.dismiss()
        }
        if (!TextUtils.isEmpty(txt)) {
            loadView?.setTitle(txt as CharSequence)
        }
        if (mContext is Activity && mContext.isFinishing) {
            return
        }
        loadView?.show()
    }

    // 关闭弹窗
    fun dismissLoading() {
        if (mContext is Activity && mContext.isFinishing) {
            return
        }
        loadView?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

}