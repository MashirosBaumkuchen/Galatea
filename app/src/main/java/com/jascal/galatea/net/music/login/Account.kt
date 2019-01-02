package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:19 PM
 * @email jascal@163.com
 * */


data class Account(
        val id: Int,
        val userName: String,
        val type: Int,
        val status: Int,
        val whitelistAuthority: Int,
        val createTime: Long,
        val salt: String,
        val tokenVersion: Int,
        val ban: Int,
        val baoyueVersion: Int,
        val donateVersion: Int,
        val vipType: Int,
        val viptypeVersion: Long,
        val anonimousUser: Boolean
)