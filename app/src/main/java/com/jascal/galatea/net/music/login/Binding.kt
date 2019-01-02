package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:33 PM
 * @email jascal@163.com
 * */


data class Binding(
        val refreshTime: Int,
        val expiresIn: Int,
        val expired: Boolean,
        val userId: Int,
        val tokenJsonStr: String,
        val url: String,
        val id: Long,
        val type: Int
)