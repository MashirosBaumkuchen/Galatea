package com.jascal.galatea.mvvm.discover.m

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.net.bean.RankResponse
import com.jascal.galatea.net.service.RankService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:33 PM
 * @email jascal@163.com
 * */

class RankModel @Inject constructor() {
    private var rankService: RankService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
        rankService = retrofit.create(RankService::class.java)
    }

    fun getRanks(): LiveData<RankResponse> {
        val data: MutableLiveData<RankResponse> = MutableLiveData()
        rankService.getSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<RankResponse> {
                    override fun onError(e: Throwable?) {
                        Log.d("requestSongs", "error")
                    }

                    override fun onNext(t: RankResponse?) {
                        data.value = t
                        Log.d("requestSongs", "next")
                    }

                    override fun onCompleted() {
                        Log.d("requestSongs", "complete")
                    }
                })
        return data
    }
}