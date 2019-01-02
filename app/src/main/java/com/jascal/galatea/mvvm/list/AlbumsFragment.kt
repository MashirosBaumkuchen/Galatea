package com.jascal.galatea.mvvm.list

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.mvvm.list.d.DaggerAlbumsComponent
import com.jascal.galatea.mvvm.list.vm.AlbumsViewModel
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
import kotlinx.android.synthetic.main.fragment_albums.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:40 PM
 * @email jascal@163.com
 * */

class AlbumsFragment : BaseFragment() {

    @Inject
    lateinit var albumsViewModel: AlbumsViewModel

    override fun layoutID(): Int {
        return R.layout.fragment_albums
    }

    override fun initData() {
        DaggerAlbumsComponent.create().inject(this)
        albumsViewModel.getUserPlaylist()
                .observe(this, Observer<UserPlaylistResponse> {
                    info.text = it.toString()
                })
    }

    override fun initView() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}