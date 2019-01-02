package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:37 PM
 * @email jascal@163.com
 * */


data class LoginResponse(
        val loginType: Int,
        val code: Int,
        val account: Account,
        val profile: Profile,
        val bindings: List<Binding>
)
