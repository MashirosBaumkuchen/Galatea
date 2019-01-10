package com.jascal.galatea.cache.impl

import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:17 PM
 * @email jascal@163.com
 * */

abstract class NetworkCache<T : Bean> {

    abstract operator fun get(key: String, clazz: Class<T>): Observable<T>
}