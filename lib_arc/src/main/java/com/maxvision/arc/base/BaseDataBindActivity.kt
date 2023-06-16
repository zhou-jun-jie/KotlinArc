package com.maxvision.arc.base

import android.util.Log
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.maxvision.arc.ext.saveAs
import com.maxvision.arc.ext.saveAsUnChecked
import java.lang.reflect.ParameterizedType

/**
 * user: zjj
 * date: 2023/6/2
 * desc: dataBinding Activity基类
 */
abstract class BaseDataBindActivity<DB : ViewBinding> : BaseActivity() {
    lateinit var mBinding : DB

    override fun setContentLayout() {
        // javaClass: 获取当前对象的Class对象
        // javaClass.genericSuperclass: 获取当前类的父类的泛型类型
        val type = javaClass.genericSuperclass
        // 将获取到的泛型类型转换为ParameterizedType,并从中提取出实际的类型参数
        val vbClass : Class<DB> = type!!.saveAs<ParameterizedType>().actualTypeArguments[0].saveAs()
        val method = vbClass.getDeclaredMethod("inflate",LayoutInflater::class.java)
        mBinding=method.invoke(this,layoutInflater)!!.saveAsUnChecked()
        setContentView(mBinding.root)
    }

    override fun getLayoutResId(): Int = 0
}