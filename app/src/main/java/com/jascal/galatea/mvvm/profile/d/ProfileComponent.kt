package com.jascal.galatea.mvvm.profile.d

import com.jascal.galatea.mvvm.profile.ProfileFragment
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 7:45 PM
 * @email jascal@163.com
 * */

@Component
interface ProfileComponent{
    fun inject(profileFragment: ProfileFragment)
}