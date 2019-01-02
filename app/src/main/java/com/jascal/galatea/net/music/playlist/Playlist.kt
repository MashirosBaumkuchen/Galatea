package com.jascal.galatea.net.music.playlist

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 8:46 PM
 * @email jascal@163.com
 * */


data class Playlist(
        val subscribers: List<Any>,
        val subscribed: Boolean,
        val creator: Creator,
        val artists: Any,
        val tracks: Any,
        val createTime: Long,
        val highQuality: Boolean,
        val privacy: Int,
        val newImported: Boolean,
        val userId: Int,
        val coverImgId: Long,
        val updateTime: Long,
        val specialType: Int,
        val anonimous: Boolean,
        val trackUpdateTime: Long,
        val trackCount: Int,
        val playCount: Int,
        val coverImgUrl: String,
        val totalDuration: Int,
        val commentThreadId: String,
        val ordered: Boolean,
        val status: Int,
        val adType: Int,
        val trackNumberUpdateTime: Long,
        val description: Any,
        val tags: List<Any>,
        val subscribedCount: Int,
        val cloudTrackCount: Int,
        val name: String,
        val id: Long
)