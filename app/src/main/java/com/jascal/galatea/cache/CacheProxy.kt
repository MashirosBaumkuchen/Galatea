package com.jascal.galatea.cache

import android.util.Log
import com.jascal.galatea.cache.impl.DiskCache
import com.jascal.galatea.cache.impl.MemoryCache
import com.jascal.galatea.cache.impl.NetworkCache
import com.jascal.galatea.net.music.Bean
import io.reactivex.Observable


/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 5:09 PM
 * @email jascal@163.com
 * */

class CacheProxy {
    private var memoryCache: ICache = MemoryCache()
    private var diskCache: ICache = DiskCache()

    /**
     * single instance
     * one, double checked model
     * two, static inner class
     * */
    companion object {
        class CacheProxyInstance {
            companion object {
                val instance: CacheProxy = CacheProxy()
            }
        }

        fun getInstance(): CacheProxy {
            return CacheProxyInstance.instance
        }
    }

    fun <T : Bean> load(key: String, clazz: Class<T>, networkCache: NetworkCache<T>): Observable<T> {
        Log.d("cacheProxy", "load start")
        val observable = Observable.concat(
                loadFromMemory(key, clazz),
                loadFromDisk(key, clazz),
                loadFromNetwork(key, clazz, networkCache))
        return observable
    }

    private fun <T : Bean> loadFromMemory(key: String, clazz: Class<T>): Observable<T> {
        return memoryCache.get(key, clazz)
                .doOnNext {
                    Log.d("cacheProxy", "memory doNext")
                }
    }

    private fun <T : Bean> loadFromDisk(key: String, clazz: Class<T>): Observable<T> {
        return diskCache.get(key, clazz)
                .doOnNext {
                    Log.d("cacheProxy", "disk doNext")
                    memoryCache.put(key, it)
                }
    }

    private fun <T : Bean> loadFromNetwork(key: String, cls: Class<T>, networkCache: NetworkCache<T>): Observable<T> {
        return networkCache.get(key, cls)
                .doOnNext { t ->
                    Log.d("cacheProxy", "net doNext")
                    diskCache.put(key, t)
                    memoryCache.put(key, t)
                }
    }
}