package com.jascal.galatea.net.music.playlist

import com.jascal.galatea.net.music.Bean

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/10 2:30 PM
 * @email jascal@163.com
 * */


data class SongsDetail(
        val songs: List<Song>,
        val privileges: List<Privilege>,
        val code: Int
) : Bean()

data class Song(
        val name: String,
        val id: Int,
        val pst: Int,
        val t: Int,
        val ar: List<Ar>,
        val alia: List<Any>,
        val pop: Int,
        val st: Int,
        val rt: String,
        val fee: Int,
        val v: Int,
        val crbt: Any,
        val cf: String,
        val al: Al,
        val dt: Int,
        val h: H,
        val m: M,
        val l: L,
        val a: Any,
        val cd: String,
        val no: Int,
        val rtUrl: Any,
        val ftype: Int,
        val rtUrls: List<Any>,
        val djId: Int,
        val copyright: Int,
        val s_id: Int,
        val rtype: Int,
        val rurl: Any,
        val mst: Int,
        val cp: Int,
        val mv: Int,
        val publishTime: Long
)
