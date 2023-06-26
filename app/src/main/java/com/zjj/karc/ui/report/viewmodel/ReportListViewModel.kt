package com.zjj.karc.ui.report.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zjj.http.callback.IApiErrorCallback
import com.zjj.http.manager.ApiManager
import com.zjj.http.viewmodel.HttpViewModel
import com.zjj.common.model.request.ReportListRequestModel
import com.zjj.common.model.response.WorkreporsBean

/**
 * user: zjj
 * date: 2023/6/25
 * desc: 报告列表viewModel
 */
class ReportListViewModel(application: Application) : HttpViewModel(application) {

    val reportData = MutableLiveData<List<WorkreporsBean>?>()

    fun loadData(start: String, end: String) : LiveData<List<WorkreporsBean>?> {
        val request = ReportListRequestModel("$start 00:00:00", "$end 23:59:59")
        launchUiWithResult(
            responseBlock = { ApiManager.api.getReportList(request) },
            errorCall = object : IApiErrorCallback {
                override fun onError(code: Int?, error: String?) {
                    super.onError(code, error)
                    reportData.value = null
                }
            },
            successBlock = {
                if (it == null) {
                    reportData.value = null
                } else {
                    reportData.value = it.workrepors
                }
            }
        )
        return reportData
    }

    fun loadData2(start: String, end: String) : LiveData<List<WorkreporsBean>?> {
        val request = ReportListRequestModel("$start 00:00:00", "$end 23:59:59")
        launchFlow(errorCall = object : IApiErrorCallback {
            override fun onError(code: Int?, error: String?) {
                super.onError(code, error)
                reportData.value = null
            }

            override fun onLoginFail(code: Int?, error: String?) {
                super.onLoginFail(code, error)
                reportData.value = null
            }
        }, requestCall = {
            ApiManager.api.getReportList(request)
        }, showLoading = {
            if (it) {
                loadingMsg.value = "正在加载..."
            } else {
                loadingMsg.value = ""
            }
        }) {
            if (it == null) {
                reportData.value = null
            } else {
                reportData.value = it.workrepors
            }
        }
        return reportData

    }




}
