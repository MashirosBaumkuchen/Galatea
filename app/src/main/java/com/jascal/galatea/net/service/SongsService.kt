package com.jascal.galatea.net.service

import com.jascal.galatea.net.bean.QianResponse
import retrofit2.http.GET
import rx.Observable


/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:32 PM
 * @email jascal@163.com
 * */

interface SongsService {

    @GET("musicRankings")
    fun getSongs(): Observable<QianResponse>
}