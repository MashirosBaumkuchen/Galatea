package com.jascal.galatea.mvvm.discover.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.jascal.galatea.mvvm.discover.d.DaggerRankComponent
import com.jascal.galatea.net.music.recommend.RecommendResponse
import com.jascal.galatea.net.service.impl.RecommendModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 8:44 PM
 * @email jascal@163.com
 * */

class DiscoverViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var recommendModel: RecommendModel

    init {
        DaggerRankComponent.create().inject(this)
    }

    fun getRecommend(): LiveData<RecommendResponse> {
        // web request
        Log.d("requestSongs", "getSongsFromWeb")
        return recommendModel.getRecommend()
    }
}