package com.jascal.galatea.mvvm.list.d

import com.jascal.galatea.mvvm.list.AlbumsFragment
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 9:11 PM
 * @email jascal@163.com
 * */

@Component
interface AlbumsComponent{
    fun inject(albumsFragment: AlbumsFragment)
}