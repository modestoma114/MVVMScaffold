package me.robbin.mvvmscaffold.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import me.robbin.mvvmscaffold.base.activity.BaseVMActivity
import me.robbin.mvvmscaffold.ext.viewmodel.getVMCls
import me.robbin.mvvmscaffold.utils.toToast
import java.lang.reflect.ParameterizedType

class MainActivity : BaseVMActivity<TestViewModel>() {

    override fun layoutRes(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        getViewModel().getString().value?.toToast()
    }

}