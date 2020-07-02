package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import me.robbin.mvvmscaffold.base.activity.BaseVMActivity
import me.robbin.mvvmscaffold.utils.toToast

class MainActivity : BaseVMActivity<TestViewModel>() {

    override fun layoutRes(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        getViewModel().getString().value?.toToast()
    }

}