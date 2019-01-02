package com.jascal.galatea.mvvm.list.d

import com.jascal.galatea.mvvm.list.vm.AlbumsViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 9:09 PM
 * @email jascal@163.com
 * */

@Component
interface AlbumsVMComponent {
    fun inject(albumsViewModel: AlbumsViewModel)
}