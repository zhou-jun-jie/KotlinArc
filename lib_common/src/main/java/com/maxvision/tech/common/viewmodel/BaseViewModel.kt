package com.maxvision.tech.common.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.maxvision.http.viewmodel.HttpViewModel

/**
 * user: zjj
 * date: 2023/6/21
 * desc: 基类viewModel
 */
open class BaseViewModel(application: Application) : HttpViewModel(application) {

    // dialog 消息
    val loadingMsg = MutableLiveData<String>()

    // toast 消息
    val toastMsg = MutableLiveData<String>()



}