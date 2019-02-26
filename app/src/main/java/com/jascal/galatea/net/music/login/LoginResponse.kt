package com.jascal.galatea.net.music.login

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:37 PM
 * @email jascal@163.com
 * */


data class LoginResponse(
        val loginType: Int = 0,
        val code: Int = 0,
        val account: Account = Account(),
        val profile: Profile = Profile(),
        val bindings: List<Binding> = ArrayList()
) : Bean()
