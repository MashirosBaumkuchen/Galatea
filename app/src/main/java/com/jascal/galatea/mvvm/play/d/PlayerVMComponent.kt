package com.jascal.galatea.mvvm.play.d

import com.jascal.galatea.mvvm.play.vm.PlayerViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/10 2:43 PM
 * @email jascal@163.com
 * */

@Component
interface PlayerVMComponent {
    fun inject(playerViewModel: PlayerViewModel)
}