package com.zjj.common.model.response

import com.chad.library.adapter.base.entity.MultiItemEntity
import java.io.Serializable

/**
 * user: zjj
 * date: 2023/6/25
 * desc: 描述
 */
data class WorkreporsBean(
    val workName: String,
    val workTime: String,
    val workEllapse: Int,
    val allArea: Int,
    val cleanTimes: Int,
    val finished: Int,
    val map : String,
    val rate : Int,
    val water : String,
    val power : String,
    val waterCount : Int,
    val powerCount : Int,
    val detergent : String,
    val cleanWaste : Int,
    val reporTime : String,
    override val itemType : Int
) : MultiItemEntity,Serializable