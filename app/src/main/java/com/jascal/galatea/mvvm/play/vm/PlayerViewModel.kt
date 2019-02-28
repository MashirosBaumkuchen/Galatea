package com.jascal.galatea.mvvm.play.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jascal.galatea.mvvm.play.d.DaggerPlayerVMComponent
import com.jascal.galatea.net.music.playlist.SongsDetail
import com.jascal.galatea.net.service.impl.MusicModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/10 2:40 PM
 * @email jascal@163.com
 * */

class PlayerViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var musicModel: MusicModel

    init {
        DaggerPlayerVMComponent.create().inject(this)
    }

    fun getSongDetail(songID: Int): LiveData<SongsDetail> {
        return musicModel.getSongDetail(songID)
    }
}