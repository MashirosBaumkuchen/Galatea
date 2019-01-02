package com.jascal.galatea.mvvm.list.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jascal.galatea.mvvm.list.d.DaggerAlbumsVMComponent
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
import com.jascal.galatea.net.service.impl.UserModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 9:08 PM
 * @email jascal@163.com
 * */

class AlbumsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var userModel: UserModel

    init {
        DaggerAlbumsVMComponent.create().inject(this)
    }

    fun getUserPlaylist(): LiveData<UserPlaylistResponse> {
        return userModel.getUserPlaylist()
    }

}