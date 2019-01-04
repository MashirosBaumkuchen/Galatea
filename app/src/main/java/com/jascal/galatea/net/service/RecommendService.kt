package com.jascal.galatea.net.service

import com.jascal.galatea.net.music.recommend.RecommendResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 2:16 PM
 * @email jascal@163.com
 * */

interface RecommendService {
    @GET("recommend/resource")
    fun getRecommendPlaylist(): Observable<RecommendResponse>
}