package com.jascal.galatea.net.bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:56 PM
 * @email jascal@163.com
 * */


data class RankResponse(
        val code: Int,
        val message: String,
        val result: List<Rank>
)
