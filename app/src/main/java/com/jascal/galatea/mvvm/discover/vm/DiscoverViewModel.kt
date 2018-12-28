package com.jascal.galatea.mvvm.discover.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.jascal.galatea.mvvm.discover.m.SongsModel
import com.jascal.galatea.net.bean.QianResponse

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 8:44 PM
 * @email jascal@163.com
 * */

class DiscoverViewModel : ViewModel() {

    fun getSongsFromWeb(): LiveData<QianResponse> {
        // web request
        Log.d("requestSongs","getSongsFromWeb")
        return SongsModel().getSongs()
    }
}