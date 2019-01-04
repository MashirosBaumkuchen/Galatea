package com.jascal.galatea.mvvm.detail

import android.arch.lifecycle.Observer
import android.support.v7.widget.LinearLayoutManager
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.detail.d.DaggerPlaylistComponent
import com.jascal.galatea.mvvm.detail.vm.PlaylistDetailViewModel
import com.jascal.galatea.net.music.playlist.PlaylistDetailResponse
import kotlinx.android.synthetic.main.activity_playlist_detail.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/30 9:55 PM
 * @email jascal@163.com
 * */

class PlaylistDetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: PlaylistDetailViewModel

    override fun layoutID(): Int {
        return R.layout.activity_playlist_detail
    }

    override fun initData() {
        DaggerPlaylistComponent.create().inject(this)
        viewModel.getPlaylistDetail(intent.getLongExtra("playlistID", 0))
                .observe(this, Observer<PlaylistDetailResponse> {
                    log("result is ${it.toString()}")
                })
    }

    override fun initView() {
        setSupportActionBar(toolbar)
        val layoutManager = LinearLayoutManager(this)
        songsList.layoutManager = layoutManager
    }

}