package com.jascal.galatea.mvvm.detail

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.detail.adapter.SongsAdapter
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

class PlaylistDetailActivity : BaseActivity(), SongsAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModel: PlaylistDetailViewModel
    private val songsAdapter = SongsAdapter(this)

    override fun layoutID(): Int {
        return R.layout.activity_playlist_detail
    }

    override fun initData() {
        Log.d("turnFunction", "in new activity")
        log("play list detail activity id is ${intent.getLongExtra("playlistID", 0)}")
        DaggerPlaylistComponent.create().inject(this)
        viewModel.getPlaylistDetail(intent.getLongExtra("playlistID", 0))
                .observe(this, Observer<PlaylistDetailResponse> {
                    log("result is ${it.toString()}")
                    it?.let {
                        songsAdapter.setData(it.playlist.tracks)
                        progressBar.visibility = View.INVISIBLE
                    }
                })
    }

    override fun initView() {
        setSupportActionBar(toolbar)
        val layoutManager = LinearLayoutManager(this)
        songsList.layoutManager = layoutManager
        songsList.adapter = songsAdapter
        back.setOnClickListener {
            back()
        }
    }

    fun back() {
        this.finish()
    }

    override fun onItemClick(view: View) {
        Log.d("turnFunction", "Click")
        val id: Long = view.tag as Long
        // open rankDetail page by type
        Toast.makeText(this, "id is $id", Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent()
        intent.setClass(this, PlaylistDetailActivity::class.java)
        intent.putExtra("songID", id)
        startActivity(intent)
    }

}