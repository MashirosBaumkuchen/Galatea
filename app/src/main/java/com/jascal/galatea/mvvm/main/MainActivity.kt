package com.jascal.galatea.mvvm.main

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun layoutID(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }
}
