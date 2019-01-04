package com.jascal.galatea.net.service.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.jascal.galatea.cache.CacheProxy
import com.jascal.galatea.cache.impl.NetworkCache
import com.jascal.galatea.net.music.Config
import com.jascal.galatea.net.music.playlist.PlaylistDetailResponse
import com.jascal.galatea.net.service.MusicService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/4 3:27 PM
 * @email jascal@163.com
 * */

class MusicModel @Inject constructor() {
    //?id=2290267281
    private val musicService: MusicService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val retrofit = Retrofit.Builder()
                .baseUrl(Config.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        musicService = retrofit.create(MusicService::class.java)
    }

    fun getPlayListDetail(playlistID: Int): LiveData<PlaylistDetailResponse> {
        val data: MutableLiveData<PlaylistDetailResponse> = MutableLiveData()
        val key = CacheProxy.generatorKey("18810659693", "playlistDetail")
        val networkCache = object : NetworkCache<PlaylistDetailResponse>() {
            override fun get(key: String, cls: Class<PlaylistDetailResponse>): Observable<PlaylistDetailResponse> {
                return musicService.getPlaylistDetail(playlistID)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        CacheProxy.getInstance().load(key, PlaylistDetailResponse::class.java, networkCache)
                .subscribe(object : Observer<PlaylistDetailResponse> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: PlaylistDetailResponse) {
                        data.value = t
                    }

                    override fun onError(e: Throwable) {
                    }
                })
        return data
    }
}