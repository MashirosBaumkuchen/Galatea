package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:21 PM
 * @email jascal@163.com
 * */


data class Profile(
        val userId: Int = 0,
        val vipType: Int = 0,
        val accountStatus: Int = 0,
        val gender: Int = 0,
        val avatarImgId: Long = 0,
        val nickname: String = "",
        val birthday: Long = 0,
        val city: Int = 0,
        val defaultAvatar: Boolean = false,
        val avatarUrl: String = "",
        val province: Int = 0,
        val userType: Int = 0,
        val backgroundImgId: Long = 0,
        val djStatus: Int = 0,
        val experts: Any = 0,
        val mutual: Boolean = false,
        val remarkName: Any = 0,
        val expertTags: Any = 0,
        val authStatus: Int = 0,
        val backgroundUrl: String = "",
        val avatarImgIdStr: String = "",
        val backgroundImgIdStr: String = "",
        val description: String = "",
        val detailDescription: String = "",
        val followed: Boolean = false,
        val signature: String = "",
        val authority: Int = 0,
        val avatarImgId_str: String = "",
        val followeds: Int = 0,
        val follows: Int = 0,
        val eventCount: Int = 0,
        val playlistCount: Int = 0,
        val playlistBeSubscribedCount: Int = 0
)
