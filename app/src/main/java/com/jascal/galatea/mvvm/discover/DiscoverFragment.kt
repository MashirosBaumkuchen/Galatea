package com.jascal.galatea.mvvm.discover

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.discover.adapter.RankAdapter
import com.jascal.galatea.mvvm.discover.d.DaggerDiscoverComponent
import com.jascal.galatea.mvvm.discover.vm.DiscoverViewModel
import com.jascal.galatea.net.music.recommend.RecommendResponse
import kotlinx.android.synthetic.main.fragment_discover.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe api https://api.apiopen.top/musicRankings
 * @data on 2018/12/27 5:28 PM
 * @email jascal@163.com
 * */

class DiscoverFragment : BaseFragment(), RankAdapter.OnRankItemClickListener {
    @Inject
    lateinit var viewModel: DiscoverViewModel
    private val rankAdapter: RankAdapter = RankAdapter(this)

    override fun layoutID(): Int {
        return R.layout.fragment_discover
    }

    override fun initData() {
        log("initData")
        DaggerDiscoverComponent.create().inject(this)
        viewModel.getRecommend().observe(this, Observer<RecommendResponse> {
            log("on get recommend")
            rankAdapter.setData(it!!.recommend)
        })

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun initView() {
        log("initView")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val layoutManager = LinearLayoutManager(this.context)
        recycler.layoutManager = layoutManager
        recycler.adapter = rankAdapter

        reflash.setOnClickListener {
            viewModel.getRecommend().observe(this, Observer<RecommendResponse> {
                log("on get recommend")
                rankAdapter.setData(it!!.recommend)
            })
        }
    }

    override fun onItemClick(view: View) {
        val id = view.tag
        // open rankDetail page by type
        Toast.makeText(context, "id is $id", Toast.LENGTH_SHORT).show()
    }
}