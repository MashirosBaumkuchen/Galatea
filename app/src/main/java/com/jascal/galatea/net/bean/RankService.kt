package com.jascal.galatea.net.bean

import io.reactivex.Observable
import retrofit2.http.GET


/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:32 PM
 * @email jascal@163.com
 * */

interface RankService {

    @GET("musicRankings")
    fun getSongs(): Observable<RankResponse>
}