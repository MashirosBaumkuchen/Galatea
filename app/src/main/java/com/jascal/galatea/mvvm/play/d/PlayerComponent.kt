package com.jascal.galatea.mvvm.play.d

import com.jascal.galatea.mvvm.play.PlayerActivity
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/10 2:42 PM
 * @email jascal@163.com
 * */

@Component
interface PlayerComponent {
    fun inject(playerActivity: PlayerActivity)
}