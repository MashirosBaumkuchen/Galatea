package com.jascal.galatea.mvvm.discover.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.jascal.galatea.mvvm.discover.d.DaggerSongsComponent
import com.jascal.galatea.mvvm.discover.m.SongsModel
import com.jascal.galatea.net.bean.QianResponse
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 8:44 PM
 * @email jascal@163.com
 * */

class DiscoverViewModel : ViewModel() {
    @Inject
    lateinit var songsModel: SongsModel

    init {
        DaggerSongsComponent.create().inject(this)
    }

    fun getSongsFromWeb(): LiveData<QianResponse> {
        // web request
        Log.d("requestSongs", "getSongsFromWeb")
        return songsModel.getSongs()
    }
}