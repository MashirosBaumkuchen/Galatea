package com.jascal.galatea.net.service

import com.jascal.galatea.net.music.playlist.PlaylistDetailResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 3:24 PM
 * @email jascal@163.com
 * */

interface MusicService {

    /**
     * get the detail information about songs
     * */

    @GET("playlist/detail")
    fun getPlaylistDetail(@Query("id") playlistID: Long): Observable<PlaylistDetailResponse>
}