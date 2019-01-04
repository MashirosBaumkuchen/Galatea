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
import com.jascal.galatea.net.music.recommend.Recommend

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/30 5:57 PM
 * @email jascal@163.com
 * */

class RecommendAdapter(var onRankItemClickListener: OnRankItemClickListener) : Adapter<RecommendAdapter.ViewHolder>() {
    private var rankData: List<Recommend>? = null

    fun setData(ranks: List<Recommend>) {
        Log.d("RankAdapter", "setdata")
        this.rankData = ranks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recommend, viewGroup, false)
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
            Glide.with(viewHolder.recommendBg.context).load(it[position].picUrl).into(viewHolder.recommendBg)
            viewHolder.itemView.tag = it[position].id
            viewHolder.first.text = it[position].name
            viewHolder.second.text = it[position].copywriter
            viewHolder.third.text = it[position].creator.nickname
            viewHolder.fourth.text = it[position].creator.signature
            Log.d("RankAdapter", "onBindViewHolder")
            return
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recommendBg = itemView.findViewById<ImageView>(R.id.recommendBg)!!
        var first = itemView.findViewById<TextView>(R.id.first)!!
        var second = itemView.findViewById<TextView>(R.id.second)!!
        var third = itemView.findViewById<TextView>(R.id.third)!!
        var fourth = itemView.findViewById<TextView>(R.id.fourth)!!
    }

    interface OnRankItemClickListener {
        fun onItemClick(view: View)
    }
}