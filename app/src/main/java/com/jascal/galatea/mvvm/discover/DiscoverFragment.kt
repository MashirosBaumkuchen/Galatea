package com.jascal.galatea.mvvm.discover

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.discover.vm.DiscoverViewModel
import com.jascal.galatea.net.bean.QianResponse
import kotlinx.android.synthetic.main.fragment_discover.*

/**
 * @author ihave4cat
 * @describe api https://api.apiopen.top/musicRankings
 * @data on 2018/12/27 5:28 PM
 * @email jascal@163.com
 * */

class DiscoverFragment : BaseFragment() {
    private val viewModel: DiscoverViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(activity!!.application).create(DiscoverViewModel::class.java)
    }

    override fun layoutID(): Int {
        return R.layout.fragment_discover
    }

    override fun initData() {
        log("initData")
        viewModel.getSongsFromWeb().observe(this, object : Observer<QianResponse> {
            override fun onChanged(qianResponse: QianResponse?) {
                Log.d("requestSongs","onChanged")
                song.text = qianResponse?.result!![0].name
            }
        })
    }

    override fun initView() {
        log("initView")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}