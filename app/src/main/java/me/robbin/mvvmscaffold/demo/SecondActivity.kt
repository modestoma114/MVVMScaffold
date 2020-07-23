package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import me.robbin.mvvmscaffold.base.DataBindingConfig
import me.robbin.mvvmscaffold.base.activity.BaseDBActivity
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.demo.databinding.ActivitySecondBinding
import me.robbin.mvvmscaffold.utils.setStatusBarTransparent

/**
 *
 * Create by Robbin at 2020/7/5
 */
class SecondActivity : BaseDBActivity<BaseViewModel, ActivitySecondBinding>() {

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_second, BR.viewModel, mViewModel)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setStatusBarTransparent()
    }

}