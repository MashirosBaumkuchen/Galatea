package com.jascal.galatea.mvvm.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jascal.galatea.R
import com.jascal.galatea.net.music.playlist.Ar
import com.jascal.galatea.net.music.playlist.Track

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/9 2:41 PM
 * @email jascal@163.com
 * */

class SongsAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {
    private var songsList: List<Track>? = null

    fun setData(songs: List<Track>) {
        this.songsList = songs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_song, viewGroup, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(it)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        songsList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        songsList?.let {
            viewHolder.itemView.tag = it[position].id
            viewHolder.name.text = it[position].name
            viewHolder.describe.text = getDescribe(it[position])
        }
    }

    private fun getDescribe(track: Track): String {
        var artists: String = ""
        for (ar: Ar in track.ar) {
            artists = artists + " " + ar.name
        }
        return "$artists, create from ${track.ar[0].name}"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val describe = itemView.findViewById<TextView>(R.id.describe)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View)
    }
}