package com.jascal.galatea.net.music.playlist

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 8:47 PM
 * @email jascal@163.com
 * */


data class UserPlaylistResponse(
        val more: Boolean,
        val playlist: List<Playlist>,
        val code: Int
)
