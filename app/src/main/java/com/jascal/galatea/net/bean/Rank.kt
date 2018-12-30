package com.jascal.galatea.net.bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:55 PM
 * @email jascal@163.com
 * */


data class Rank(
        val pic_s210: String,
        val bg_pic: String,
        val web_url: String,
        val color: String,
        val pic_s444: String,
        val name: String,
        val count: Int,
        val comment: String,
        val type: Int,
        val pic_s192: String,
        val content: List<RankItem>,
        val pic_s260: String
)
