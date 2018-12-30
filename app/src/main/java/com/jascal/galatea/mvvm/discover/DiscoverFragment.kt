package com.jascal.galatea.mvvm.discover

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.discover.d.DaggerDiscoverComponent
import com.jascal.galatea.mvvm.discover.vm.DiscoverViewModel
import com.jascal.galatea.net.bean.QianResponse
import kotlinx.android.synthetic.main.fragment_discover.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe api https://api.apiopen.top/musicRankings
 * @data on 2018/12/27 5:28 PM
 * @email jascal@163.com
 * */

class DiscoverFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: DiscoverViewModel

    override fun layoutID(): Int {
        return R.layout.fragment_discover
    }

    override fun initData() {
        log("initData")
        DaggerDiscoverComponent.create().inject(this)

        viewModel.getSongsFromWeb().observe(this, Observer<QianResponse> { qianResponse ->
            Log.d("requestSongs", "onChanged")
            song.text = qianResponse?.result!![0].name
        })
    }

    override fun initView() {
        log("initView")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}