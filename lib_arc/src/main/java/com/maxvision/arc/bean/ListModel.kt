package com.maxvision.arc.bean

/**
 * user: zjj
 * date: 2023/6/21
 * desc: 描述
 */
const val STATE_LOAD_ERROR = -2
const val STATE_ERROR = -1
const val STATE_DATA = 0
const val STATE_EMPTY = 1

data class ListModel(val code : Int,val msg : String)