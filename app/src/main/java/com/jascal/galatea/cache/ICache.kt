package com.jascal.galatea.cache

import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:11 PM
 * @email jascal@163.com
 * */

interface ICache {
    fun <T : Bean> get(key: String, value: Class<T>): Observable<T>


    fun <T : Bean> put(key: String, value: T)
}