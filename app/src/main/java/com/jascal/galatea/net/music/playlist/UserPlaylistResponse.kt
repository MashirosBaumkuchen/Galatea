package com.jascal.galatea.net.music.playlist

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 8:47 PM
 * @email jascal@163.com
 * */


data class UserPlaylistResponse(
        val more: Boolean = false,
        val playlist: List<Playlist> = ArrayList(),
        val code: Int = 0
) : Bean()
