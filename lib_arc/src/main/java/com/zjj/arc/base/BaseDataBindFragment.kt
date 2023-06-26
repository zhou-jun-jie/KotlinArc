package com.zjj.arc.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.zjj.arc.ext.saveAs
import com.zjj.arc.ext.saveAsUnChecked
import java.lang.reflect.ParameterizedType

/**
 * user: zjj
 * date: 2023/6/14
 * desc: 描述
 */
abstract class BaseDataBindFragment<DB : ViewBinding> : BaseFragment() {
    //This property is only valid between onCreateView and onDestroyView.
    var mBinding: DB? = null

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        val type = javaClass.genericSuperclass
        val vbClass: Class<DB> = type!!.saveAs<ParameterizedType>().actualTypeArguments[0].saveAs()
        val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mBinding = method.invoke(this, layoutInflater)!!.saveAsUnChecked()
        return mBinding!!.root
    }

    override fun getLayoutResId(): Int = 0

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}