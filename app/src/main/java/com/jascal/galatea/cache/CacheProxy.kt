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

        /**
         * TODO change to a md5 encode model
         * */
        fun generatorKey(value: String, action: String): String {
            return value + action
        }
    }

    fun <T : Bean> load(key: String, clazz: Class<T>, networkCache: NetworkCache<T>, tag:String = "cache"): Observable<T> {
        Log.d("cacheProxy", "$tag :cache load start")
        return Observable.concat(
                loadFromMemory(key, clazz, tag),
                loadFromDisk(key, clazz, tag),
                loadFromNetwork(key, clazz, networkCache, tag))
                .first(clazz.newInstance()).toObservable()
    }

    private fun <T : Bean> loadFromMemory(key: String, clazz: Class<T>, tag:String): Observable<T> {
        return memoryCache
                .get(key, clazz)
                .doOnNext {
                }
                .doOnError {
                    Log.d("cacheProxy", "$tag :cache from memory read error, maybe there is no cache in memory")
                }
                .doOnComplete {
                    Log.d("cacheProxy", "$tag :cache loaded from memory!")
                }
    }

    private fun <T : Bean> loadFromDisk(key: String, clazz: Class<T>, tag:String): Observable<T> {
        return diskCache
                .get(key, clazz)
                .doOnNext {
                    memoryCache.put(key, it)
                }
                .doOnError {
                    Log.d("cacheProxy", "$tag :cache from disk read error, maybe there is no cache in disk")
                }
                .doOnComplete {
                    Log.d("cacheProxy", "$tag :cache loaded from disk!")
                }
    }

    private fun <T : Bean> loadFromNetwork(key: String, cls: Class<T>, networkCache: NetworkCache<T>, tag:String): Observable<T> {
        return networkCache
                .get(key, cls)
                .doOnNext { t ->
                    diskCache.put(key, t)
                    memoryCache.put(key, t)
                }
                .doOnError {
                    Log.d("cacheProxy", "$tag :cache from net read error, network error")
                }
                .doOnComplete {
                    Log.d("cacheProxy", "$tag :cache loaded from net!")
                }
    }
}