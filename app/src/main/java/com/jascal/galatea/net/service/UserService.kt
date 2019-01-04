package com.jascal.galatea.net.service

import com.jascal.galatea.net.music.login.LoginResponse
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 7:34 PM
 * @email jascal@163.com
 * */

interface UserService {

    /**
     * get user`s info
     * */

    @GET("login/cellphone")
    fun login(@Query("phone") phone: String, @Query("password") password: String)
            : Observable<LoginResponse>

    @GET("user/playlist")
    fun getUserPlaylist(@Query("uid") userId: Int): Observable<UserPlaylistResponse>
}