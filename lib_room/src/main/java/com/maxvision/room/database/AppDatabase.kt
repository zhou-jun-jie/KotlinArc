package com.maxvision.room.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.maxvision.arc.helper.AppHelper
import com.maxvision.room.dao.UserDao
import com.maxvision.room.entity.User
import kotlin.concurrent.thread

/**
 * user: zjj
 * date: 2023/6/20
 * desc: 数据库操作类
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var database: AppDatabase? = null

        @Synchronized
        fun getInstance(): AppDatabase {
            return database ?: buildDatabase().also {
                database = it
            }
        }

        private fun buildDatabase() = Room.databaseBuilder(
            AppHelper.getApplication(), AppDatabase::class.java,
            "APP_DB"
        )
            .addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    // 在创建后预填充数据(在子线程)
                    thread {
                        getInstance().userDao().insert(PREPOPULATE_DATA)
                    }.start()
                }
            })
            // 允许在主线程查询,默认是false
            .allowMainThreadQueries()
            .addMigrations()
            //设置数据库工厂，用来链接room和SQLite，可以利用自行创建SupportSQLiteOpenHelper，来实现数据库加密
            //.openHelperFactory()
            .build()

        // 技巧1: 预填充数据
        val PREPOPULATE_DATA = listOf(User("1", "val"), User("2", "val 2"))
    }
}