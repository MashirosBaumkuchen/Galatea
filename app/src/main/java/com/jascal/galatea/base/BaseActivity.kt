package com.jascal.galatea.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/26 10:30 AM
 * @email jascal@163.com
 * */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID())
        initData()
        initView()
    }

    abstract fun layoutID(): Int

    abstract fun initData()

    abstract fun initView()

}