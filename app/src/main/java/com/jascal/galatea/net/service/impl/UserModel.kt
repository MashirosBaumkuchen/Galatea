package com.jascal.galatea.net.service.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.net.music.Config
import com.jascal.galatea.net.music.login.Response
import com.jascal.galatea.net.service.UserService
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
 * @data on 2019/1/2 7:51 PM
 * @email jascal@163.com
 * */

class UserModel @Inject constructor() {
    private val userService: UserService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val retrofit = Retrofit.Builder()
                .baseUrl(Config.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
        userService = retrofit.create(UserService::class.java)
    }

    fun login(): LiveData<Response> {
        val data: MutableLiveData<Response> = MutableLiveData()
        userService.login("18810659693", "blackcherry")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response> {
                    override fun onError(e: Throwable?) {
                        Log.d("loginResponse", "error")
                        Log.d("loginResponse", "${e.toString()}")
                    }

                    override fun onNext(t: Response?) {
                        data.value = t
                        Log.d("loginResponse", "error")
                    }

                    override fun onCompleted() {
                        Log.d("loginResponse", "error")
                    }

                })
        return data
    }
}