package com.jascal.galatea.remote

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.jascal.galatea.remote.impl.MusicPlayer

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 5:53 PM
 * @email jascal@163.com
 * */

open class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        Log.d("aidl-galatea", "service is created")
        mediaPlayer = MediaPlayer()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("aidl-galatea", "service is onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.d("aidl-galatea", "service is onBind")
        return MusicPlayer(mediaPlayer, this)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("aidl-galatea", "service is onUnBind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("aidl-galatea", "service is onDestroy")
    }
}