package com.jascal.galatea.mvvm.discover.d

import com.jascal.galatea.mvvm.discover.DiscoverFragment
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/30 4:27 PM
 * @email jascal@163.com
 * */

@Component
interface DiscoverComponent {
    fun inject(discoverFragment: DiscoverFragment)
}