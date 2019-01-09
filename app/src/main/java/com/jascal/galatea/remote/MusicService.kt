package com.jascal.galatea.remote

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.jascal.galatea.IMusicPlayer
import com.jascal.galatea.remote.impl.MusicPlayer

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 5:53 PM
 * @email jascal@163.com
 * */

class MusicService : Service() {
    private val iMusicPlayer: IMusicPlayer.Stub = MusicPlayer(this)

    override fun onBind(intent: Intent?): IBinder {
        return iMusicPlayer
    }

}