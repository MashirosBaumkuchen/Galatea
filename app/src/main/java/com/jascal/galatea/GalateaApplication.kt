package com.jascal.galatea

import android.app.Application

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 2:25 PM
 * @email jascal@163.com
 * */

class GalateaApplication : Application() {
    companion object {
        const val debug: Boolean = true
    }

    override fun onCreate() {
        super.onCreate()

    }
}