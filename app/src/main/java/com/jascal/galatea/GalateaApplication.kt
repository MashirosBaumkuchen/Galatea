package com.jascal.galatea

import android.app.Application
import android.content.Context

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 2:25 PM
 * @email jascal@163.com
 * */

class GalateaApplication : Application() {
    private lateinit var ROOT_DIR: String

    companion object {
        const val debug: Boolean = true

        lateinit var INSTANCE: GalateaApplication

        fun getInstance(): GalateaApplication {
            return INSTANCE
        }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        ROOT_DIR = getDir("galatea", Context.MODE_PRIVATE).absolutePath
        if (!ROOT_DIR.endsWith("/")) {
            ROOT_DIR += "/"
        }
    }

    fun getRootDir(): String {
        return ROOT_DIR
    }
}