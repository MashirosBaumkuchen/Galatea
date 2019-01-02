package com.jascal.galatea.mvvm.profile.d

import com.jascal.galatea.mvvm.profile.vm.ProfileViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 8:00 PM
 * @email jascal@163.com
 * */

@Component
interface ProfileVMComponent {
    fun inject(profileViewModel: ProfileViewModel)
}