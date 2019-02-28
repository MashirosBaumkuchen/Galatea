package com.jascal.galatea.mvvm.login

import android.arch.lifecycle.Observer
import android.text.TextUtils
import android.util.Log
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.mvvm.login.d.DaggerLoginComponent
import com.jascal.galatea.mvvm.login.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/2/28 2:07 PM
 * @email jascal@163.com
 * */

class LoginActivity : BaseActivity() {
    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun layoutID(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        DaggerLoginComponent.create().inject(this)

    }

    override fun initView() {
        confirm.setOnClickListener {
            if (!(TextUtils.isEmpty(cellphone.text) || TextUtils.isEmpty(password.text))) {
                loginViewModel
                        .login(cellphone.text.toString(), password.text.toString())
                        .observe(this, Observer {
                            Log.d("login", it.toString())
                            if (it?.code == 200) {
                                turn()
                            }
                        })
            }
        }
    }

    fun turn() {
        this.finish()
    }

}