package com.jascal.galatea.net.service.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jascal.galatea.cache.CacheProxy
import com.jascal.galatea.cache.impl.NetworkCache
import com.jascal.galatea.net.music.Config
import com.jascal.galatea.net.music.login.LoginResponse
import com.jascal.galatea.net.music.playlist.UserPlaylistResponse
import com.jascal.galatea.net.service.UserService
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        userService = retrofit.create(UserService::class.java)
    }

    fun login(): LiveData<LoginResponse> {
        val key = CacheProxy.generatorKey("18810659693", Config.ACTION_LOGIN)
        val data: MutableLiveData<LoginResponse> = MutableLiveData()
        val networkCache = object : NetworkCache<LoginResponse>() {
            override fun get(key: String, clazz: Class<LoginResponse>): Observable<LoginResponse> {
                return userService.login("18810659693", "blackcherry")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }
        CacheProxy.getInstance()
                .load(key, LoginResponse::class.java, networkCache, tag = "login")
                .subscribe(object : Observer<LoginResponse> {
                    override fun onError(e: Throwable) {
                        Log.d("cacheProxy", "error")
                        Log.d("cacheProxy", "because ${e.message}")
                    }

                    override fun onNext(t: LoginResponse) {
                        data.value = t
                        Log.d("cacheProxy", "onNext")
                    }

                    override fun onComplete() {
                        Log.d("cacheProxy", "onCompleted")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }
                })
        return data
    }

    fun getUserPlaylist(userId: Int = 293334466): LiveData<UserPlaylistResponse> {
        val key = CacheProxy.generatorKey(userId.toString(), Config.ACTION_PLAYLIST)
        val data: MutableLiveData<UserPlaylistResponse> = MutableLiveData()
        val networkCache = object : NetworkCache<UserPlaylistResponse>() {
            override fun get(key: String, clazz: Class<UserPlaylistResponse>): Observable<UserPlaylistResponse> {
                return userService.getUserPlaylist(userId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }
        CacheProxy.getInstance()
                .load(key, UserPlaylistResponse::class.java, networkCache, tag="usersPlaylist")
                .subscribe(object : Observer<UserPlaylistResponse> {
                    override fun onComplete() {
                        Log.d("getUserPlaylist", "onCompleted")
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: UserPlaylistResponse) {
                        data.value = t
                        Log.d("getUserPlaylist", "onCompleted")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("getUserPlaylist", "error")
                        Log.d("getUserPlaylist", "$e")
                    }
                })
        return data
    }


}

