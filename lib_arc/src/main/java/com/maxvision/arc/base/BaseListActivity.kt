package com.maxvision.arc.base

import android.os.Bundle
import android.view.View
import com.maxvision.arc.bean.ListModel
import com.maxvision.base.R
import com.maxvision.base.databinding.LayoutListBinding
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener

/**
 * user: zjj
 * date: 2023/6/25
 * desc: 列表基类界面
 */
abstract class BaseListActivity<DB : LayoutListBinding,T : BaseViewModel> : BaseMvvmActivity<DB,T>(),OnRefreshListener,OnLoadMoreListener {

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.refreshLayout.setOnRefreshListener(this)
        mBinding.refreshLayout.setOnLoadMoreListener(this)
        mBinding.refreshLayout.setEnableLoadMore(loadMore())
        setEmptyView()
        loadData()
    }

    abstract fun loadData()

    override fun getLayoutResId(): Int {
        return R.layout.layout_list
    }

    protected fun loadMore(): Boolean {
        return false
    }

    private fun setEmptyView() {
        mViewModel.listMsg.observe(this) { listModel: ListModel -> showEView(listModel) }
    }

    protected open fun showButton(isShow: Boolean) {
        mBinding.tvSure.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    private fun showEView(listModel: ListModel) {
        when (listModel.state) {
            ListModel.STATE_EMPTY -> if (mBinding.refreshLayout.isRefreshing) {
                mBinding.refreshLayout.finishRefresh()
                mBinding.groupEmpty.visibility = View.VISIBLE
                mBinding.iv.setImageResource(R.drawable.ic_empty)
                mBinding.tvMsg.text = getString(R.string.data_empty)
            } else if (mBinding.refreshLayout.isLoading) {
                mBinding.refreshLayout.finishLoadMoreWithNoMoreData()
            }

            ListModel.STATE_DATA -> {
                mBinding.groupEmpty.visibility = View.GONE
                mBinding.refreshLayout.visibility = View.VISIBLE
                if (mBinding.refreshLayout.isRefreshing) {
                    mBinding.refreshLayout.finishRefresh()
                } else if (mBinding.refreshLayout.isLoading) {
                    mBinding.refreshLayout.finishLoadMore()
                }
            }

            ListModel.STATE_ERROR -> if (mBinding.refreshLayout.isRefreshing) {
                mBinding.refreshLayout.finishRefresh(false)
                mBinding.groupEmpty.visibility = View.VISIBLE
                mBinding.iv.setImageResource(R.drawable.vector_drawable_ic_error)
                mBinding.tvMsg.text = getString(R.string.network_error)
            }

            ListModel.STATE_LOAD_ERROR -> if (mBinding.refreshLayout.isLoading) {
                mBinding.refreshLayout.finishLoadMore(false)
            }
            else -> mBinding.groupEmpty.visibility = View.GONE
        }
    }

}