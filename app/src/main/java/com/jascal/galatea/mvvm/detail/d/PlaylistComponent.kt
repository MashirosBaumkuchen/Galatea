package com.jascal.galatea.mvvm.detail.d

import com.jascal.galatea.mvvm.detail.PlaylistDetailActivity
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 4:16 PM
 * @email jascal@163.com
 * */

@Component
interface PlaylistComponent {
    fun inject(playlistDetailActivity: PlaylistDetailActivity)
}