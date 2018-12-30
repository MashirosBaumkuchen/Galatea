package com.jascal.galatea.mvvm.discover.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jascal.galatea.R
import com.jascal.galatea.net.bean.Rank

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/30 5:57 PM
 * @email jascal@163.com
 * */

class RankAdapter : Adapter<RankAdapter.ViewHolder>() {
    private var rankData: List<Rank>? = null

    fun setData(ranks: List<Rank>) {
        Log.d("RankAdapter", "setdata")
        this.rankData = ranks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rank, viewGroup, false)
        Log.d("RankAdapter", "onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        rankData?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        rankData?.let{
            Log.d("RankAdapter", "onBindViewHolder")
            Log.d("RankAdapter", "${it[position].name}")
            viewHolder.title.text = it[position].name
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
    }
}