package com.jascal.galatea.mvvm.profile.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jascal.galatea.mvvm.profile.d.DaggerProfileVMComponent
import com.jascal.galatea.net.music.login.LoginResponse
import com.jascal.galatea.net.service.impl.UserModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/2 7:42 PM
 * @email jascal@163.com
 * */

class ProfileViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var userModel: UserModel

    init {
        DaggerProfileVMComponent.create().inject(this)
    }

    fun login(): LiveData<LoginResponse> {
        return userModel.login()
    }

}