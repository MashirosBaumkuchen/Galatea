package com.jascal.galatea.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/26 10:44 AM
 * @email jascal@163.com
 * */

abstract class BaseFragment : Fragment() {
    val TAG: String = this::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutID(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    abstract fun layoutID(): Int

    abstract fun initData()

    abstract fun initView()
}