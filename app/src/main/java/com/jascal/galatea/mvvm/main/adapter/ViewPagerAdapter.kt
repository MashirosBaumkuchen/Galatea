package com.jascal.galatea.mvvm.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:46 PM
 * @email jascal@163.com
 * */

class ViewPagerAdapter(var fragments: MutableList<Fragment>, fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    /**
     * do not destroy invisible item
     * TODO change to lazy load fragment
     * */
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
    }

}