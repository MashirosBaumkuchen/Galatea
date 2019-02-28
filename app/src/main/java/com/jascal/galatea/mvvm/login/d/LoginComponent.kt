package com.jascal.galatea.mvvm.login.d

import com.jascal.galatea.mvvm.login.LoginActivity
import dagger.Component

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/2/28 2:20 PM
 * @email jascal@163.com
 * */

@Component
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}
