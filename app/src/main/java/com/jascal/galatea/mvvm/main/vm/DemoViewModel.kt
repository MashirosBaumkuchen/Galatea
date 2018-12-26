package com.jascal.galatea.mvvm.main.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/26 3:21 PM
 * @email jascal@163.com
 * */

class DemoViewModel : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


}