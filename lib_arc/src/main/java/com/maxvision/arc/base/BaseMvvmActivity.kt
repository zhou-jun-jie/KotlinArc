package com.maxvision.arc.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.maxvision.arc.utils.TipsToast
import java.lang.reflect.ParameterizedType

/**
 * user: zjj
 * date: 2023/6/2
 * desc: dataBinding + viewModel基类
 */
abstract class BaseMvvmActivity<DB : ViewBinding,VM : BaseViewModel> : BaseDataBindActivity<DB>() {

    lateinit var mViewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        super.onCreate(savedInstanceState)
        setMsgListener()
    }

    private fun initViewModel() {
        val argument = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        mViewModel = ViewModelProvider(this)[argument[1] as Class<VM>]
    }

    private fun setMsgListener() {
        mViewModel.loadingMsg.observe(this) {
            if (it.isNullOrEmpty()) {
                hideLoading()
            } else {
                showLoading()
            }
        }
        mViewModel.toastMsg.observe(this) {
            TipsToast.showTips(it)
        }
    }

}