package com.jascal.galatea.mvvm.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import com.jascal.galatea.R
import com.jascal.galatea.base.BaseActivity
import com.jascal.galatea.mvvm.main.vm.DemoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var mModel: DemoViewModel
    private var index = 0

    override fun layoutID(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        mModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
                .create(DemoViewModel::class.java)
        val demoObserver = Observer<String> { name ->
            textView.text = name
        }
        mModel.currentName.observe(this, demoObserver)

        buttonView.setOnClickListener {
            val anotherName = "ihave${index++}cat"
            mModel.currentName.setValue(anotherName)
        }
    }

    override fun initView() {
    }
}
