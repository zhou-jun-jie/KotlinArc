package com.maxvision.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.maxvision.room.entity.User
import com.maxvision.room.entity.UserAndAllPets
import com.maxvision.room.entity.UserMinimal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 描述
 */
@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user")
    fun getUsers() : List<User>

    // 返回我们需要的实体类
    @Query("SELECT name,age From user")
    fun getDataMinimal() : List<UserMinimal>

    @Transaction
    @Query("SELECT * FROM user")
    fun getUserAndAllPets() : List<UserAndAllPets>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserByIdFlow(id : String) : Flow<User>

    // 去除重复,避免多次或者误发通知
    fun getUserByIdDistinctFlow(id : String) : Flow<User> = getUserByIdFlow(id).distinctUntilChanged()

}