package com.jascal.galatea.base.I

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2018/12/26 10:51 AM
 * @email jascal@163.com
 * */

interface IPresenter<in T : IView> {
    fun detach()

    fun attach(rootView: T)
}