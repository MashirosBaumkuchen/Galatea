package com.jascal.galatea.cache.impl

import android.text.TextUtils
import android.util.LruCache
import com.google.gson.Gson
import com.jascal.galatea.cache.ICache
import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.io.UnsupportedEncodingException

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:16 PM
 * @email jascal@163.com
 * */

class MemoryCache : ICache {
    private var lruCache: LruCache<String, String>

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

    override fun <T : Bean> get(key: String, clazz: Class<T>): Observable<T> {
        return Observable.create(ObservableOnSubscribe<T> { emitter ->
            val result = lruCache.get(key)
            if (emitter.isDisposed) {
                return@ObservableOnSubscribe
            }
            if (TextUtils.isEmpty(result)) {
//                    emitter.onNext()
            } else {
                val t = Gson().fromJson<T>(result, clazz)
                emitter.onNext(t)
            }
            emitter.onComplete()
        })
    }

    override fun <T : Bean> put(key: String, value: T) {
        val dataString = Gson().toJson(value)
        lruCache.put(key, dataString)
    }
}