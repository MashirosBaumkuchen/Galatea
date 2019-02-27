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

//        bottom_navigation
//                .animate()
//                .translationX(150)
//                .translationY(200)
//                .setDuration(200)
//                .start()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        when (item.itemId) {
            R.id.discover -> {
                viewPage.setCurrentItem(0, true)
            }
            R.id.albums -> {
                viewPage.setCurrentItem(1, true)
            }
            R.id.profile -> {
                viewPage.setCurrentItem(2, true)
            }
        }
        return true
    }
}
