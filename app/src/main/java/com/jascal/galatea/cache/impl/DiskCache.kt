package com.jascal.galatea.cache.impl

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.jascal.galatea.cache.ICache
import com.jascal.galatea.net.music.Bean
import com.jascal.galatea.util.FileUtils
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 3:17 PM
 * @email jascal@163.com
 * */

class DiskCache : ICache {
    private var DISK_PATH: String = FileUtils.getCacheDir()

    override fun <T : Bean> get(key: String, clazz: Class<T>): Observable<T> {
        return Observable.create(object : ObservableOnSubscribe<T> {
            override fun subscribe(emitter: ObservableEmitter<T>) {
                Log.d("cacheProxy", "disk is subscribe")

                val filename = DISK_PATH + key
                val result = FileUtils.readTextFromSDcard(filename)

                Log.d("cacheProxy", "filename is $filename")
                Log.d("cacheProxy", "class is ${clazz.canonicalName}")
                Log.d("cacheProxy", "result is $result")


                if (emitter.isDisposed) {
                    return
                }
                if (TextUtils.isEmpty(result)) {
                    Log.d("cacheProxy", "disk is empty")
//                    emitter.onNext()
                } else {
                    Log.d("cacheProxy", "======= start gson")

                    val t = Gson().fromJson(result, clazz)

                    Log.d("cacheProxy", "T is ${t::class.java}")
                    Log.d("cacheProxy", "T is ${t.toString()}")

                    emitter.onNext(t)
                }
                emitter.onComplete()
            }

        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun <T : Bean> put(key: String, value: T) {
        Observable.create(ObservableOnSubscribe<T> { emitter ->
            Log.d("cacheProxy", "save to disk: $key")

            val filename = DISK_PATH + key

            // ========
            val result = Gson().toJson(value)
            Log.d("cacheProxy", "disk to json $result")

            FileUtils.saveTextToSdcard(filename, result)
            if (!emitter.isDisposed) {
                Log.d("cacheProxy", "save to disk success")

                emitter.onNext(value)
                emitter.onComplete()
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

}