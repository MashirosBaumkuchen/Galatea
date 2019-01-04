package com.jascal.galatea.net.music.recommend

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 2:22 PM
 * @email jascal@163.com
 * */


data class Recommend(
        val id: Long,
        val type: Int,
        val name: String,
        val copywriter: String,
        val picUrl: String,
        val playcount: Int,
        val createTime: Long,
        val creator: Creator,
        val trackCount: Int,
        val userId: Int,
        val alg: String
)
