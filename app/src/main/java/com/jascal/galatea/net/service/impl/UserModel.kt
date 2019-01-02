package com.jascal.galatea.net.service.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.net.music.Config
import com.jascal.galatea.net.music.login.LoginResponse
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
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

    fun login(): LiveData<LoginResponse> {
        val data: MutableLiveData<LoginResponse> = MutableLiveData()
        userService.login("18810659693", "blackcherry")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<LoginResponse> {
                    override fun onError(e: Throwable?) {
                        Log.d("loginResponse", "error")
                        Log.d("loginResponse", "${e.toString()}")
                    }

                    override fun onNext(t: LoginResponse?) {
                        data.value = t
                        Log.d("loginResponse", "onNext")
                    }

                    override fun onCompleted() {
                        Log.d("loginResponse", "onCompleted")
                    }

                })
        return data
    }

    fun getUserPlaylist(userId: Int = 293334466): LiveData<UserPlaylistResponse> {
        val data: MutableLiveData<UserPlaylistResponse> = MutableLiveData()
        userService.getUserPlaylist(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<UserPlaylistResponse> {
                    override fun onError(e: Throwable?) {
                        Log.d("getUserPlaylist", "error")
                        Log.d("getUserPlaylist", "${e.toString()}")
                    }

                    override fun onNext(t: UserPlaylistResponse?) {
                        data.value = t
                        Log.d("getUserPlaylist", "onCompleted")
                    }

                    override fun onCompleted() {
                        Log.d("getUserPlaylist", "onCompleted")
                    }

                })
        return data
    }


}

