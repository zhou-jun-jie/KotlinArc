package com.zjj.karc.ui.report

import android.util.Log
import com.zjj.arc.base.BaseListActivity
import com.zjj.karc.ui.report.viewmodel.ReportListViewModel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.zjj.arc.databinding.LayoutListBinding
import com.zjj.common.utils.DateUtils


/**
 * user: zjj
 * date: 2023/6/25
 * desc: 任务报告列表界面
 */
class ReportListActivity : BaseListActivity<LayoutListBinding, ReportListViewModel>(){

    private val month = 30L * 1000 * 60 * 60 * 24 // 30天数据

    private val end = System.currentTimeMillis()
    private val start = end - month

    override fun loadData() {
        mViewModel.loadData2(DateUtils.formatTime(start, "yyyy-MM-dd"), DateUtils.formatTime(end, "yyyy-MM-dd"))
        mViewModel.reportData.observe(this) {
            Log.e("zjj_report","size:${it!!.size}")
        }
    }


    override fun onRefresh(refreshLayout: RefreshLayout) {

    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {

    }

}