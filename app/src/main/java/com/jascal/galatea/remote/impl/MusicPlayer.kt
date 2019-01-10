package com.jascal.galatea.remote.impl

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import com.jascal.galatea.IMusicPlayer

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 5:51 PM
 * @email jascal@163.com
 * */

class MusicPlayer constructor(var mediaPlayer: MediaPlayer, var context: Context) : IMusicPlayer.Stub() {

    override fun play(uri: String?) {
        Log.d("aidl-galatea", "function play, process is ${android.os.Process.myPid()}")
        mediaPlayer.reset()
        mediaPlayer.setDataSource(context, Uri.parse(uri))
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    override fun isPlaying(): Boolean {
        return mediaPlayer.isPlaying
    }

    override fun getDuration(): Int {
        return mediaPlayer.duration
    }

    override fun getCurrentPosition(): Int {
        return mediaPlayer.currentPosition
    }

    override fun seekTo(position: Int) {
        return mediaPlayer.seekTo(position)
    }


}