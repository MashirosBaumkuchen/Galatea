package com.jascal.galatea.mvvm.list

import android.support.v7.app.AppCompatActivity
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_discover.*

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:40 PM
 * @email jascal@163.com
 * */

class AlbumsFragment : BaseFragment() {
    override fun layoutID(): Int {
        return R.layout.fragment_albums
    }

    override fun initData() {
    }

    override fun initView() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}