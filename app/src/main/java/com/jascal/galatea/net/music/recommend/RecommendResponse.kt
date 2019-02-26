package com.jascal.galatea.net.music.recommend

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 2:23 PM
 * @email jascal@163.com
 * */


data class RecommendResponse(
        val code: Int = 0,
        val featureFirst: Boolean = false,
        val haveRcmdSongs: Boolean = false,
        val recommend: List<Recommend> = ArrayList()
) : Bean()

