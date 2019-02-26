package com.jascal.galatea.net.music.playlist

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe this a total bean from a simple request
 * @data on 2019/1/4 3:38 PM
 * @email jascal@163.com
 * */


data class PlaylistDetailResponse(
        val playlist: PlaylistWithTrack = PlaylistWithTrack(),
        val code: Int = 0,
        val privileges: List<Privilege> = ArrayList()
) : Bean()

data class PlaylistWithTrack(
        val subscribers: List<Any> = ArrayList(),
        val subscribed: Boolean=false,
        val creator: PlaylistCreator = PlaylistCreator(),
        val tracks: List<Track> = ArrayList(),
        val trackIds: List<TrackId> = ArrayList(),
        val tags: List<String> = ArrayList(),
        val createTime: Long= 0,
        val highQuality: Boolean=false,
        val subscribedCount: Int= 0,
        val cloudTrackCount: Int= 0,
        val trackNumberUpdateTime: Long= 0,
        val adType: Int= 0,
        val ordered: Boolean=false,
        val updateTime: Long= 0,
        val specialType: Int= 0,
        val privacy: Int= 0,
        val newImported: Boolean=false,
        val userId: Int= 0,
        val commentThreadId: String="",
        val coverImgId: Long= 0,
        val trackUpdateTime: Long= 0,
        val trackCount: Int= 0,
        val coverImgUrl: String="",
        val playCount: Int= 0,
        val description: String="",
        val status: Int= 0,
        val name: String="",
        val id: Long= 0,
        val shareCount: Int= 0,
        val coverImgId_str: String="",
        val commentCount: Int= 0
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
        val defaultAvatar: Boolean=false,
        val province: Int=0,
        val authStatus: Int=0,
        val followed: Boolean=false,
        val avatarUrl: String="",
        val accountStatus: Int=0,
        val gender: Int=0,
        val city: Int=0,
        val birthday: Long=0,
        val userId: Int= 0,
        val userType: Int= 0,
        val nickname: String="",
        val signature: String="",
        val description: String="",
        val detailDescription: String="",
        val avatarImgId: Long= 0,
        val backgroundImgId: Long= 0,
        val backgroundUrl: String="",
        val authority: Int= 0,
        val mutual: Boolean=false,
        val expertTags: Any= 0,
        val experts: Any= 0,
        val djStatus: Int= 0,
        val vipType: Int= 0,
        val remarkName: Any= 0,
        val backgroundImgIdStr: String="",
        val avatarImgIdStr: String="",
        val avatarImgId_str: String=""
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