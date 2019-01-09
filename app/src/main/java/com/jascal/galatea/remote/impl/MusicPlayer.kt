package com.jascal.galatea.remote.impl

import android.content.Context
import android.util.Log
import com.jascal.galatea.IMusicPlayer

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 5:51 PM
 * @email jascal@163.com
 * */

class MusicPlayer constructor(var context: Context) : IMusicPlayer.Stub() {

    override fun play(uri: String?) {
        Log.d("aidl-galatea", "function play, process is ${android.os.Process.myPid()}")
    }

}