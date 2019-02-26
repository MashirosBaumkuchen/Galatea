package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:19 PM
 * @email jascal@163.com
 * */


data class Account(
        val id: Int = 0,
        val userName: String = "",
        val type: Int = 0,
        val status: Int = 0,
        val whitelistAuthority: Int = 0,
        val createTime: Long = 0,
        val salt: String = "",
        val tokenVersion: Int = 0,
        val ban: Int = 0,
        val baoyueVersion: Int = 0,
        val donateVersion: Int = 0,
        val vipType: Int = 0,
        val viptypeVersion: Long = 0,
        val anonimousUser: Boolean = false
)