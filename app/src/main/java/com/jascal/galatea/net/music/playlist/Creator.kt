package com.jascal.galatea.net.music.playlist

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 8:41 PM
 * @email jascal@163.com
 * */


data class Creator(
        val defaultAvatar: Boolean,
        val province: Int,
        val authStatus: Int,
        val followed: Boolean,
        val avatarUrl: String,
        val accountStatus: Int,
        val gender: Int,
        val city: Int,
        val birthday: Long,
        val userId: Int,
        val userType: Int,
        val nickname: String,
        val signature: String,
        val description: String,
        val detailDescription: String,
        val avatarImgId: Long,
        val backgroundImgId: Long,
        val backgroundUrl: String,
        val authority: Int,
        val mutual: Boolean,
        val expertTags: Any,
        val experts: Any,
        val djStatus: Int,
        val vipType: Int,
        val remarkName: Any,
        val avatarImgIdStr: String,
        val backgroundImgIdStr: String,
        val avatarImgId_str: String
)