package com.jascal.galatea.net.music.playlist

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe this a total bean from a simple request
 * @data on 2019/1/4 3:38 PM
 * @email jascal@163.com
 * */


data class PlaylistDetailResponse(
        val playlist: PlaylistWithTrack,
        val code: Int,
        val privileges: List<Privilege>
) : Bean()

data class PlaylistWithTrack(
        val subscribers: List<Any>,
        val subscribed: Boolean,
        val creator: PlaylistCreator,
        val tracks: List<Track>,
        val trackIds: List<TrackId>,
        val tags: List<String>,
        val createTime: Long,
        val highQuality: Boolean,
        val subscribedCount: Int,
        val cloudTrackCount: Int,
        val trackNumberUpdateTime: Long,
        val adType: Int,
        val ordered: Boolean,
        val updateTime: Long,
        val specialType: Int,
        val privacy: Int,
        val newImported: Boolean,
        val userId: Int,
        val commentThreadId: String,
        val coverImgId: Long,
        val trackUpdateTime: Long,
        val trackCount: Int,
        val coverImgUrl: String,
        val playCount: Int,
        val description: String,
        val status: Int,
        val name: String,
        val id: Long,
        val shareCount: Int,
        val coverImgId_str: String,
        val commentCount: Int
)

data class Track(
        val name: String,
        val id: Int,
        val pst: Int,
        val t: Int,
        val ar: List<Ar>,
        val alia: List<Any>,
        val pop: Int,
        val st: Int,
        val rt: String,
        val fee: Int,
        val v: Int,
        val crbt: Any,
        val cf: String,
        val al: Al,
        val dt: Int,
        val h: H,
        val m: M,
        val l: L,
        val a: Any,
        val cd: String,
        val no: Int,
        val rtUrl: Any,
        val ftype: Int,
        val rtUrls: List<Any>,
        val djId: Int,
        val copyright: Int,
        val s_id: Int,
        val mst: Int,
        val cp: Int,
        val mv: Int,
        val rtype: Int,
        val rurl: Any,
        val publishTime: Long,
        val tns: List<String>
)

data class L(
        val br: Int,
        val fid: Int,
        val size: Int,
        val vd: Double
)

data class Al(
        val id: Int,
        val name: String,
        val picUrl: String,
        val tns: List<Any>,
        val pic_str: String,
        val pic: Long
)

data class M(
        val br: Int,
        val fid: Int,
        val size: Int,
        val vd: Double
)

data class Ar(
        val id: Int,
        val name: String,
        val tns: List<Any>,
        val alias: List<Any>
)

data class H(
        val br: Int,
        val fid: Int,
        val size: Int,
        val vd: Double
)

data class PlaylistCreator(
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
        val backgroundImgIdStr: String,
        val avatarImgIdStr: String,
        val avatarImgId_str: String
)

data class TrackId(
        val id: Int,
        val v: Int
)

data class Privilege(
        val id: Int,
        val fee: Int,
        val payed: Int,
        val st: Int,
        val pl: Int,
        val dl: Int,
        val sp: Int,
        val cp: Int,
        val subp: Int,
        val cs: Boolean,
        val maxbr: Int,
        val fl: Int,
        val toast: Boolean,
        val flag: Int,
        val preSell: Boolean
)