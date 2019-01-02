package com.jascal.galatea.net.music.login

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 2:21 PM
 * @email jascal@163.com
 * */


data class Profile(
        val userId: Int,
        val vipType: Int,
        val accountStatus: Int,
        val gender: Int,
        val avatarImgId: Long,
        val nickname: String,
        val birthday: Long,
        val city: Int,
        val defaultAvatar: Boolean,
        val avatarUrl: String,
        val province: Int,
        val userType: Int,
        val backgroundImgId: Long,
        val djStatus: Int,
        val experts: Any,
        val mutual: Boolean,
        val remarkName: Any,
        val expertTags: Any,
        val authStatus: Int,
        val backgroundUrl: String,
        val avatarImgIdStr: String,
        val backgroundImgIdStr: String,
        val description: String,
        val detailDescription: String,
        val followed: Boolean,
        val signature: String,
        val authority: Int,
        val avatarImgId_str: String,
        val followeds: Int,
        val follows: Int,
        val eventCount: Int,
        val playlistCount: Int,
        val playlistBeSubscribedCount: Int
)
