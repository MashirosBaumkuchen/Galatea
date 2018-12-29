package com.jascal.galatea.mvvm.discover.d

import com.jascal.galatea.mvvm.discover.vm.DiscoverViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/29 1:18 PM
 * @email jascal@163.com
 * */

@Component(modules = [SongsModule::class])
interface SongsComponent {
    fun inject(discoverViewModel: DiscoverViewModel)
}