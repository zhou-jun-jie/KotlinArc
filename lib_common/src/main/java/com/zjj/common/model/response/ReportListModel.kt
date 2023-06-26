package com.zjj.common.model.response

import java.io.Serializable

/**
 * user: zjj
 * date: 2023/6/25
 * desc: 报告列表实体类
 */
class ReportListModel(val sum : Int, val workrepors : List<WorkreporsBean>) : Serializable {

}
