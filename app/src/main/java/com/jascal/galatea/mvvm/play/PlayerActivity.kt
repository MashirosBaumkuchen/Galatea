package com.jascal.galatea.mvvm.play

import android.arch.lifecycle.Observer
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.jascal.galatea.IMusicPlayer
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.mvvm.play.d.DaggerPlayerComponent
import com.jascal.galatea.mvvm.play.vm.PlayerViewModel
import com.jascal.galatea.net.music.playlist.SongsDetail
import com.jascal.galatea.remote.Config
import kotlinx.android.synthetic.main.activity_player.*
import kotlinx.android.synthetic.main.layout_player.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe // a.https://music.163.com/song/media/outer/url?id=$songID.mp3
 *           // b.retrofit GET /song/url?id=$songID
 * @data on 2019/1/9 4:55 PM
 * @email jascal@163.com
 * */

class PlayerActivity : BaseActivity() {
    private lateinit var musicPlayer: IMusicPlayer
    private var songID: Int = -1
    @Inject
    lateinit var playerViewModel: PlayerViewModel

    override fun layoutID(): Int {
        return R.layout.activity_player
    }

    override fun initData() {
        songID = intent.getIntExtra("songID", 0)
        Log.d("aidl-galatea", "song id is $songID")
        DaggerPlayerComponent.create().inject(this)
        initService()

        playerViewModel.getSongDetail(songID)
                .observe(this, Observer<SongsDetail> { it ->
                    it?.let {
                        if (it.songs.isNotEmpty()) {
                            songsName.text = it.songs[0].name
                            Glide.with(this@PlayerActivity).load(it.songs[0].al.picUrl).into(cover)
                        }
                    }
                })
    }

    override fun initView() {
    }

    private fun initService() {
        val intent = Intent()
        intent.action = Config.ACTION
        intent.`package` = Config.PACKAGE
        startService(intent)
        bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    private fun getStatusBarHeight(): Int {
        var result: Int = 0
        val resourceID = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceID > 0) {
            result = resources.getDimensionPixelSize(resourceID)
        }
        return result
    }


    private val conn = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            musicPlayer = IMusicPlayer.Stub.asInterface(iBinder)
            Toast.makeText(this@PlayerActivity, "ready", Toast.LENGTH_SHORT).show()
            Log.d("aidl-galatea", "in playerActivity, and process is ${android.os.Process.myPid()}")
            musicPlayer.play("https://music.163.com/song/media/outer/url?id=$songID.mp3")
        }

        override fun onServiceDisconnected(componentName: ComponentName) {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(conn)
    }

}