package com.jascal.galatea.mvvm.detail.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jascal.galatea.mvvm.detail.d.DaggerPlaylistVMComponent
import com.jascal.galatea.net.music.playlist.PlaylistDetailResponse
import com.jascal.galatea.net.service.impl.MusicModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 4:14 PM
 * @email jascal@163.com
 * */

class PlaylistDetailViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var musicModel: MusicModel

    init {
        DaggerPlaylistVMComponent.create().inject(this)
    }

    fun getPlaylistDetail(playlistID: Long): LiveData<PlaylistDetailResponse> {
        return musicModel.getPlayListDetail(playlistID)
    }

}