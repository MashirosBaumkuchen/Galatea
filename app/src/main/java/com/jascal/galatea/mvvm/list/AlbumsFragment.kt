package com.jascal.galatea.mvvm.list

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.mvvm.list.adapter.PlaylistAdapter
import com.jascal.galatea.mvvm.list.d.DaggerAlbumsComponent
import com.jascal.galatea.mvvm.list.vm.AlbumsViewModel
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.layout_playlist.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:40 PM
 * @email jascal@163.com
 * */

class AlbumsFragment : BaseFragment(), PlaylistAdapter.OnItemClickListener {
    @Inject
    lateinit var albumsViewModel: AlbumsViewModel
    private var playlistAdapter: PlaylistAdapter = PlaylistAdapter(this)

    override fun layoutID(): Int {
        return R.layout.fragment_albums
    }

    override fun initData() {
        DaggerAlbumsComponent.create().inject(this)

        albumsViewModel.getUserPlaylist()
                .observe(this, Observer<UserPlaylistResponse> {
                    playlistAdapter.setData(it!!.playlist)
                })
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun initView() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val layoutManager = LinearLayoutManager(this.context)
        playlist.layoutManager = layoutManager
        playlist.adapter = playlistAdapter
    }

    override fun onItemClick(view: View) {
        val id = view.tag
        // open rankDetail page by type
        Toast.makeText(context, "id is $id", Toast.LENGTH_SHORT).show()
    }
}