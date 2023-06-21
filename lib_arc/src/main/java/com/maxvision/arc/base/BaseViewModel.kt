package com.maxvision.arc.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * user: zjj
 * date: 2023/6/21
 * desc: 基类viewModel
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    // dialog 消息
    val loadingMsg = MutableLiveData<String>()

    // toast 消息
    val toastMsg = MutableLiveData<String>()


}