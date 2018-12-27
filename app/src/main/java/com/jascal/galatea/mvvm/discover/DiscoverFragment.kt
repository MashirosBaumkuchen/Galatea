package com.jascal.galatea.mvvm.discover

import android.support.v7.app.AppCompatActivity
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.ext.log
import kotlinx.android.synthetic.main.fragment_discover.*

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:28 PM
 * @email jascal@163.com
 * */

class DiscoverFragment : BaseFragment() {
    override fun layoutID(): Int {
        return R.layout.fragment_discover
    }

    override fun initData() {
        log("initData")
    }

    override fun initView() {
        log("initView")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}