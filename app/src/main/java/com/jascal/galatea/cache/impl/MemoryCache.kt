package com.jascal.galatea.cache.impl

import android.util.LruCache
import com.jascal.galatea.cache.ICache
import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable
import java.io.UnsupportedEncodingException

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:16 PM
 * @email jascal@163.com
 * */

class MemoryCache : ICache {
    private lateinit var lruCache: LruCache<String, String>

    init {
        val maxMemory = Runtime.getRuntime().maxMemory() / 8
        lruCache = object : LruCache<String, String>(maxMemory.toInt()) {
            override fun sizeOf(key: String, value: String): Int {
                return try {
                    value.toByteArray(charset("UTF-8")).size
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                    value.toByteArray().size
                }
            }
        }
    }

    override fun <T : Bean> get(key: String, value: Class<T>): Observable<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Bean> put(key: String, value: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}