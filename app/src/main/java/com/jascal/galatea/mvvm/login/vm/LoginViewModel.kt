package com.jascal.galatea.mvvm.login.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jascal.galatea.mvvm.login.d.DaggerLoginVMComponent
import com.jascal.galatea.net.music.login.LoginResponse
import com.jascal.galatea.net.service.impl.UserModel
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/2/28 2:18 PM
 * @email jascal@163.com
 * */

class LoginViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var userModel: UserModel

    init {
        DaggerLoginVMComponent.create().inject(this)
    }

    fun login(cellphone: String = "18810659693", password: String = "blackcherry"): LiveData<LoginResponse> {
        return userModel.login(cellphone, password)
    }

    fun isLogined(): Boolean {

        return false
    }
}