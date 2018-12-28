package com.jascal.galatea.ext

import android.util.Log
import com.jascal.galatea.GalateaApplication
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.base.BaseFragment
import com.jascal.galatea.widget.ModelSwitcher

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/27 3:30 PM
 * @email jascal@163.com
 * */

fun BaseActivity.log(msg: String) {
    if (GalateaApplication.debug) {
        Log.d(TAG, msg)
    }
}

fun BaseFragment.log(msg: String) {
    if (GalateaApplication.debug) {
        Log.d(TAG, msg)
    }
}

fun ModelSwitcher.log(msg:String){
    if(GalateaApplication.debug){
        Log.d("ModelSwitcher", msg)
    }
}