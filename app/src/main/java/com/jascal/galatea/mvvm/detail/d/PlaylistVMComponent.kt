package com.jascal.galatea.mvvm.detail.d

import com.jascal.galatea.mvvm.detail.vm.PlaylistDetailViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 4:18 PM
 * @email jascal@163.com
 * */

@Component
interface PlaylistVMComponent {
    fun inject(playlistDetailViewModel: PlaylistDetailViewModel)
}