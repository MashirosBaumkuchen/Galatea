package com.jascal.galatea.mvvm.main

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.mvvm.discover.DiscoverFragment
import com.jascal.galatea.mvvm.list.AlbumsFragment
import com.jascal.galatea.mvvm.main.adapter.ViewPagerAdapter
import com.jascal.galatea.mvvm.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun layoutID(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        bottom_navigation.setOnNavigationItemSelectedListener(this)

        val discoverFragment = DiscoverFragment()
        val listFragment = AlbumsFragment()
        val profileFragment = ProfileFragment()

        val fragments: MutableList<Fragment> = ArrayList()
        fragments.add(discoverFragment)
        fragments.add(listFragment)
        fragments.add(profileFragment)

        viewPage.adapter = ViewPagerAdapter(fragments, supportFragmentManager)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }
}
