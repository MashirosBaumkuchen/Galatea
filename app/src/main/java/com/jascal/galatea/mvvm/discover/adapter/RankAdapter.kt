package com.jascal.galatea.mvvm.discover.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jascal.galatea.R
import com.jascal.galatea.net.bean.Rank

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/30 5:57 PM
 * @email jascal@163.com
 * */

class RankAdapter(var onRankItemClickListener: OnRankItemClickListener) : Adapter<RankAdapter.ViewHolder>() {
    private var rankData: List<Rank>? = null

    fun setData(ranks: List<Rank>) {
        Log.d("RankAdapter", "setdata")
        this.rankData = ranks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rank, viewGroup, false)
        Log.d("RankAdapter", "onCreateViewHolder")
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener { v -> onRankItemClickListener.onItemClick(v) }
        return viewHolder
    }

    override fun getItemCount(): Int {
        rankData?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        rankData?.let {
            Glide.with(viewHolder.rankBg.context).load(it[position].pic_s192).into(viewHolder.rankBg)
            viewHolder.rankTitle.text = it[position].name
            viewHolder.first.text = generateInfo(1, it[position].content[0].title, it[position].content[0].author)
            viewHolder.second.text = generateInfo(2, it[position].content[1].title, it[position].content[1].author)
            viewHolder.third.text = generateInfo(3, it[position].content[2].title, it[position].content[2].author)
            viewHolder.fourth.text = generateInfo(4, it[position].content[3].title, it[position].content[3].author)
            viewHolder.itemView.tag = it[position].type
            Log.d("RankAdapter", "onBindViewHolder")
            return
        }
    }

    private fun generateInfo(i: Int, title: String, author: String): String {
        return "$i  $title $author"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rankBg = itemView.findViewById<ImageView>(R.id.rankBg)
        var rankTitle = itemView.findViewById<TextView>(R.id.rankTitle)
        var first = itemView.findViewById<TextView>(R.id.first)
        var second = itemView.findViewById<TextView>(R.id.second)
        var third = itemView.findViewById<TextView>(R.id.third)
        var fourth = itemView.findViewById<TextView>(R.id.fourth)
    }

    interface OnRankItemClickListener {
        fun onItemClick(view: View)
    }
}