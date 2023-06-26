package com.zjj.arc.utils

import android.view.Gravity
import androidx.annotation.StringRes
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.ToastUtils
import com.zjj.arc.R

/**
 * name：ysf
 * date：2023/6/2
 * desc：吐司
 */
object AppToast {

    //统一设置吐司样式
    private val toast: ToastUtils = ToastUtils.make()
        .setTextSize(18)
        .setTextColor(ColorUtils.getColor(R.color.white))
        .setGravity(Gravity.CENTER, 0, 0)
        .setBgColor(ColorUtils.getColor(R.color.transparent_black))

    fun showShort(text: String) {
        toast.setDurationIsLong(false).show(text)
    }

    fun showShort(@StringRes resId: Int) {
        toast.setDurationIsLong(false).show(resId)
    }

    fun showLong(text: CharSequence) {
        toast.setDurationIsLong(true).show(text)
    }

    fun showLong(@StringRes resId: Int) {
        toast.setDurationIsLong(true).show(resId)
    }
}