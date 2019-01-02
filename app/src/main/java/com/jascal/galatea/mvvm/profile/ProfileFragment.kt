package com.jascal.galatea.mvvm.profile

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.mvvm.profile.d.DaggerProfileComponent
import com.jascal.galatea.mvvm.profile.vm.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.layout_user_profile.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 5:41 PM
 * @email jascal@163.com
 * */

class ProfileFragment : BaseFragment() {

    @Inject
    lateinit var profileViewModel: ProfileViewModel

    override fun layoutID(): Int {
        return R.layout.fragment_profile
    }

    override fun initData() {
        DaggerProfileComponent.create().inject(this)
        profileViewModel.login()
                .observe(this, Observer {
                    val profile = it?.profile
                    Glide.with(context!!).load(profile!!.avatarUrl).into(avatar)
                    Glide.with(context!!).load(profile.backgroundUrl).into(bg)
                    nickname.text = profile.nickname
                })
    }

    override fun initView() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

    }

}