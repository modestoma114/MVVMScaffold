package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import me.robbin.mvvmscaffold.base.activity.BaseDBActivity
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.demo.databinding.ActivitySecondBinding
import me.robbin.mvvmscaffold.ext.viewmodel.getAppVM
import me.robbin.mvvmscaffold.utils.setStatusBarTransparent

/**
 *
 * Create by Robbin at 2020/7/5
 */
class SecondActivity: BaseDBActivity<BaseViewModel, ActivitySecondBinding>() {

    private val appViewModel by lazy { getAppVM<TestViewModel>() }

    override val layoutRes: Int
        get() = R.layout.activity_second

    override fun initVariable() {
        mBinding.viewmodel = appViewModel
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setStatusBarTransparent()
    }

}