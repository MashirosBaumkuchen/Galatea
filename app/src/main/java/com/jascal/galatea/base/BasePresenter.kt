package com.jascal.galatea.base

import com.jascal.galatea.base.I.IPresenter
import com.jascal.galatea.base.I.IView

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/26 10:52 AM
 * @email jascal@163.com
 * */

open class BasePresenter<T : IView> : IPresenter<T> {
    var rootView: T? = null
        private set

    val isAttached: Boolean
        get() = rootView != null

    override fun attach(rootView: T) {
        this.rootView = rootView
    }

    override fun detach() {
        this.rootView = null
    }

    fun isAttached() {
        if (!isAttached) {
            throw GalateaPresenterNoFoundException()
        }
    }

    private class GalateaPresenterNoFoundException internal constructor() :
            RuntimeException("Call IPresenter.attach(rootView: T) before request data.")
}
