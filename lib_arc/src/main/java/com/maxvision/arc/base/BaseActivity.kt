package com.maxvision.arc.base

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.maxvision.arc.utils.BarUtils
import com.maxvision.arc.utils.LoadingUtils
import com.maxvision.arc.utils.TipsToast
import com.maxvision.base.R

/**
 * user: zjj
 * date: 2023/5/26
 * desc: activity基类
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var TAG: String? = this::class.java.simpleName

    private val dialogUtils by lazy {
        LoadingUtils(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
        BarUtils.setStatusBarLightMode(this, true)
        super.onCreate(savedInstanceState)
        setContentLayout()
        initView(savedInstanceState)
        initData()
    }

    open fun setContentLayout() {
        setContentView(getLayoutResId())
    }

    // 初始化视图
    abstract fun getLayoutResId(): Int

    // 初始化布局
    abstract fun initView(savedInstanceState: Bundle?)

    // 初始化数据
    open fun initData() {}

    // 显示加载框
    fun showLoading() {
        showLoading(
            getString(
                R.string.default_loading
            )
        )
    }

    // 显示dialog
    fun showLoading(msg: String?) {
        dialogUtils.showLoading(msg)
    }

    // 关闭dialog
    fun hideLoading() {
        dialogUtils.dismissLoading()
    }

    // 显示toast
    fun showToast(@StringRes resId: Int) {
        TipsToast.showTips(resId)
    }

}