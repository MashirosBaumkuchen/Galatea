package com.jascal.galatea.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import com.jascal.galatea.R

/**
 * @author ihave4cat
 * @describe a viewPager which can control its scrolling ability
 * @data on 2018/12/27 8:43 PM
 * @email jascal@163.com
 * */

class ScrollViewPager : ViewPager {
    private var scrollable: Boolean = false
        set

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScrollViewPager)
        scrollable = typedArray.getBoolean(R.styleable.ScrollViewPager_scrollAble, false)
        typedArray.recycle()
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (!scrollable) scrollable else super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (!scrollable) scrollable else super.onTouchEvent(ev)
    }
}