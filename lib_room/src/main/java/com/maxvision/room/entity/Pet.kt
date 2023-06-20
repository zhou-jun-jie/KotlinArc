package com.maxvision.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 宠物
 */
@Entity(
    tableName = "pet",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("owner")
    )]
)
data class Pet(
    @PrimaryKey val id: String,
    val name : String,
    val owner : String
)