package com.jascal.galatea.mvvm.discover.m

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.net.bean.QianResponse
import com.jascal.galatea.net.service.SongsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/28 9:33 PM
 * @email jascal@163.com
 * */

class SongsModel{
    private var songsService: SongsService

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
        songsService = retrofit.create(SongsService::class.java)
    }

    fun getSongs(): LiveData<QianResponse> {
        val data: MutableLiveData<QianResponse> = MutableLiveData()
        songsService.getSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<QianResponse> {
                    override fun onError(e: Throwable?) {
                        Log.d("requestSongs","error")
                    }

                    override fun onNext(t: QianResponse?) {
                        data.value = t
                        Log.d("requestSongs","next")
                    }

                    override fun onCompleted() {
                        Log.d("requestSongs","complete")
                    }
                })
        return data
    }

}