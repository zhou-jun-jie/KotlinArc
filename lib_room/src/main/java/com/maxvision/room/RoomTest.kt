package com.maxvision.room

import com.maxvision.room.database.AppDatabase

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 描述
 */
class RoomTest {

    fun main() {
        // 简单使用
        val users = AppDatabase.getInstance().userDao().getUsers()
    }

}