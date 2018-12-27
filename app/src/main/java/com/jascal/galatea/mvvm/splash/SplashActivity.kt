package com.jascal.galatea.mvvm.splash

import android.animation.Animator
import android.content.Intent
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.ext.log
import com.jascal.galatea.mvvm.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 2:40 PM
 * @email jascal@163.com
 * */

class SplashActivity : BaseActivity() {

    override fun layoutID(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        log("initData")
    }

    override fun initView() {
        log("initView")
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                log("animator repeat")
            }

            override fun onAnimationEnd(animation: Animator?) {
                log("animator end")
                turn()
            }

            override fun onAnimationCancel(animation: Animator?) {
                log("animator cancel")
            }

            override fun onAnimationStart(animation: Animator?) {
                log("animator start")
            }

        })
    }

    fun turn() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

}