package com.maxvision.arc.base

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.maxvision.arc.bean.ListModel

/**
 * user: zjj
 * date: 2023/6/21
 * desc: 列表viewmodel基类
 */
class BaseListViewModel(application: Application) : BaseViewModel(application){

    // 列表空或者错误信息展示
    val listMsg = MutableLiveData<ListModel>()

}