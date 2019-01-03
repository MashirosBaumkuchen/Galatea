package com.jascal.galatea.cache.impl

import com.jascal.galatea.cache.ICache
import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:17 PM
 * @email jascal@163.com
 * */

class DeskCache:ICache{
    override fun <T : Bean> get(key: String, value: Class<T>): Observable<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Bean> put(key: String, value: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}