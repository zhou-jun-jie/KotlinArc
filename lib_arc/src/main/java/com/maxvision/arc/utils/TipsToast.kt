package com.maxvision.arc.utils

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maxvision.base.databinding.WidgetTipsToastBinding

/**
 * user: zjj
 * date: 2023/6/2
 * desc: toast工具类
 */
object TipsToast {

    private var toast: Toast? = null

    private lateinit var mContext: Application

    private val mToastHandler = Looper.myLooper()?.let { Handler(it) }

    private val mBinding by lazy {
        WidgetTipsToastBinding.inflate(LayoutInflater.from(mContext), null, false)
    }

    fun init(context: Application) {
        mContext = context
    }

    fun showTips(@StringRes stringId: Int) {
        val msg = mContext.getString(stringId)
        showTipsImpl(
            msg,
            Toast.LENGTH_SHORT
        )
    }

    fun showTips(@StringRes stringId: Int, duration: Int) {
        val msg = mContext.getString(stringId)
        showTipsImpl(msg, duration)
    }

    private fun showTipsImpl(
        msg: String?,
        duration: Int,
        @DrawableRes drawableId: Int = 0
    ) {
        if (msg.isNullOrEmpty()) {
            return
        }
        toast?.let {
            cancel()
            toast = null
        }
        mToastHandler?.postDelayed({
            try {
                toast = Toast(mContext)
                toast?.view = mBinding.root
                mBinding.tipToastTxt.text = msg
                mBinding.tipToastTxt.setCompoundDrawablesWithIntrinsicBounds(
                    drawableId, 0,0,0
                )
                toast?.setGravity(Gravity.CENTER,0,0)
                toast?.duration = duration
                toast?.show()
            } catch (e : Exception) {
                e.printStackTrace()
                Log.e("show tips error","$e")
            }
        },50)
    }


    fun cancel() {
        toast?.cancel()
        mToastHandler?.removeCallbacksAndMessages(null)
    }
}