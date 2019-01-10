package com.jascal.galatea.net.service.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.cache.CacheProxy
import com.jascal.galatea.cache.impl.NetworkCache
import com.jascal.galatea.net.music.Config
import com.jascal.galatea.net.music.recommend.RecommendResponse
import com.jascal.galatea.net.service.RecommendService
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
 * @data on 2019/1/4 2:25 PM
 * @email jascal@163.com
 * */

class RecommendModel @Inject constructor() {
    private val recommendService: RecommendService

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
        recommendService = retrofit.create(RecommendService::class.java)
    }

    fun getRecommend(): LiveData<RecommendResponse> {
        val key = CacheProxy.generatorKey("18810659693", "recommend")
        val data: MutableLiveData<RecommendResponse> = MutableLiveData()
        val networkCache = object : NetworkCache<RecommendResponse>() {
            override fun get(key: String, clazz: Class<RecommendResponse>): Observable<RecommendResponse> {
                return recommendService.getRecommendPlaylist()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        CacheProxy.getInstance().load(key, RecommendResponse::class.java, networkCache)
                .subscribe(object : Observer<RecommendResponse> {
                    override fun onComplete() {
                        Log.d("recommend", "complete")
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: RecommendResponse) {
                        data.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.d("recommend", "error")
                    }
                })

        return data
    }
}