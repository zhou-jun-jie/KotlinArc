package com.maxvision.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 基类Dao
 *
 */
interface BaseDao<T> {

    /**
     * 插入单个数据
     */
    @Insert
    fun insert(obj : T)

    /**
     * 插入多个数据
     */
    @Insert
    fun insert(vararg obj: T)

    /**
     * 插入一个集合
     */
    @Insert
    fun insert(obj : List<T>)

    @Update
    fun update(obj : T)

    @Delete
    fun delete(obj : T)

}