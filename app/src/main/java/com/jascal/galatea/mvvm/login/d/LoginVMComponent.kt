package com.jascal.galatea.mvvm.login.d

import com.jascal.galatea.mvvm.login.vm.LoginViewModel
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/2/28 2:21 PM
 * @email jascal@163.com
 * */

@Component
interface LoginVMComponent {
    fun inject(loginViewModel: LoginViewModel)
}