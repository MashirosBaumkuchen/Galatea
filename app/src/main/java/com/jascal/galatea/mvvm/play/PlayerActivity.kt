package com.jascal.galatea.mvvm.play

import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 4:55 PM
 * @email jascal@163.com
 * */

class PlayerActivity : BaseActivity() {
    override fun layoutID(): Int {
        return R.layout.activity_player
    }

    override fun initData() {
        val songID = intent.getLongExtra("playlistID", 0)

        // https://music.163.com/song/media/outer/url?id=$songID.mp3
        // retrofit GET /song/url?id=$songID
    }

    override fun initView() {

    }

}