package com.jascal.galatea.mvvm.discover.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.jascal.galatea.mvvm.discover.d.DaggerRankComponent
import com.jascal.galatea.mvvm.discover.m.RankModel
import com.jascal.galatea.net.bean.RankResponse
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 8:44 PM
 * @email jascal@163.com
 * */

class DiscoverViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var rankModel: RankModel

    init {
        DaggerRankComponent.create().inject(this)
    }

    fun getRanksFromApi(): LiveData<RankResponse> {
        // web request
        Log.d("requestSongs", "getSongsFromWeb")
        return rankModel.getRanks()
    }
}