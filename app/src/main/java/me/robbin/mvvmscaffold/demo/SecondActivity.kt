package me.robbin.mvvmscaffold.demo

import me.robbin.mvvmscaffold.base.activity.BaseDBActivity
import me.robbin.mvvmscaffold.base.viewmodel.NoViewModel
import me.robbin.mvvmscaffold.demo.databinding.ActivitySecondBinding
import me.robbin.mvvmscaffold.ext.viewmodel.getAppVM

/**
 *
 * Create by Robbin at 2020/7/5
 */
class SecondActivity: BaseDBActivity<NoViewModel, ActivitySecondBinding>() {

    private val appViewModel by lazy { getAppVM<TestViewModel>() }

    override val layoutRes: Int
        get() = R.layout.activity_second

    override fun initVariable() {
        mBinding.viewmodel = appViewModel
    }

}