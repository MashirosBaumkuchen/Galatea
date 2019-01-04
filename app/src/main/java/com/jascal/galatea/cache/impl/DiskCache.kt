package com.jascal.galatea.cache.impl

import android.text.TextUtils
import com.google.gson.Gson
import com.jascal.galatea.cache.ICache
import com.jascal.galatea.net.music.Bean
import com.jascal.galatea.util.FileUtils
import io.reactivex.Observable
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
        return Observable.create(ObservableOnSubscribe<T> { emitter ->
            val filename = DISK_PATH + key
            val result = FileUtils.readTextFromSDcard(filename)

            if (emitter.isDisposed) {
                return@ObservableOnSubscribe
            }
            if (TextUtils.isEmpty(result)) {
//                    emitter.onNext()
            } else {
                val t = Gson().fromJson(result, clazz)
                emitter.onNext(t)
            }
            emitter.onComplete()
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun <T : Bean> put(key: String, value: T) {
        Observable.create(ObservableOnSubscribe<T> { emitter ->
            val filename = DISK_PATH + key

            val result = Gson().toJson(value)

            FileUtils.saveTextToSdcard(filename, result)
            if (!emitter.isDisposed) {
                emitter.onNext(value)
                emitter.onComplete()
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

}