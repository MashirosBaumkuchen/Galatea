package com.jascal.galatea.mvvm.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jascal.galatea.R
import com.jascal.galatea.net.music.playlist.Playlist

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 9:34 PM
 * @email jascal@163.com
 * */

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private var playlistData: List<Playlist>? = null

    fun setData(playlist: List<Playlist>) {
        this.playlistData = playlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_playlist, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        playlistData?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        playlistData?.let {
            Glide.with(viewHolder.cover.context).load(it[position].coverImgUrl).into(viewHolder.cover)
            viewHolder.name.text = it[position].name
            viewHolder.describe.text = generateInfo(it[position])
        }
    }

    private fun generateInfo(playlist: Playlist): String {
        return if (playlist.subscribedCount != 0) "${playlist.trackCount}首, forked from ${playlist.creator.nickname}"
        else "${playlist.trackCount}首"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cover: ImageView = itemView.findViewById(R.id.cover)
        val name: TextView = itemView.findViewById(R.id.name)
        val describe: TextView = itemView.findViewById(R.id.describe)
    }
}