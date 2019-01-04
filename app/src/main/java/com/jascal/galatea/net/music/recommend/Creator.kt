package com.jascal.galatea.net.music.recommend

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 2:18 PM
 * @email jascal@163.com
 * */


data class Creator(
    val avatarImgId: Long,
    val backgroundImgId: Long,
    val detailDescription: String,
    val defaultAvatar: Boolean,
    val expertTags: List<String>,
    val djStatus: Int,
    val mutual: Boolean,
    val remarkName: Any,
    val backgroundUrl: String,
    val avatarImgIdStr: String,
    val backgroundImgIdStr: String,
    val accountStatus: Int,
    val userId: Int,
    val vipType: Int,
    val province: Int,
    val gender: Int,
    val nickname: String,
    val birthday: Long,
    val city: Int,
    val followed: Boolean,
    val avatarUrl: String,
    val authStatus: Int,
    val userType: Int,
    val description: String,
    val signature: String,
    val authority: Int
)