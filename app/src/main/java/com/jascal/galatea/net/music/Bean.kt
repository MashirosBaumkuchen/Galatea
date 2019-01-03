package com.jascal.galatea.net.music

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:05 PM
 * @email jascal@163.com
 * */

abstract class Bean {

    private var createTime: Long = -1

    companion object {
        private const val TIME_LIMIT: Long = 60 * 60 * 1000
    }

    init {
        createTime = System.currentTimeMillis()
    }


    fun isVaild(): Boolean {
        return System.currentTimeMillis() - createTime > TIME_LIMIT
    }
}