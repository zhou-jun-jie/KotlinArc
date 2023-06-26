package com.zjj.karc

import android.content.Intent
import android.os.Bundle
import com.zjj.arc.base.BaseDataBindActivity
import com.zjj.karc.databinding.ActivityMainBinding
import com.zjj.karc.ui.report.ReportListActivity

class MainActivity : BaseDataBindActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.setClickListener {
            startActivity(Intent(this, ReportListActivity::class.java))
        }
    }

}
