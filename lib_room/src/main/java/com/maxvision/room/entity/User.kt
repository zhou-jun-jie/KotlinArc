package com.maxvision.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 用户信息
 */
@Entity(tableName = "user")
data class User(@PrimaryKey val id: String, val value: String, val name: String = "test", val age: Int = 20)