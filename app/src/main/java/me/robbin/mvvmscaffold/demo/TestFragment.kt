package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import me.robbin.mvvmscaffold.base.fragment.BaseDBFragment
import me.robbin.mvvmscaffold.demo.databinding.FragmentTestBinding
import me.robbin.mvvmscaffold.utils.setStatusBarLightMode

/**
 *
 * Create by Robbin at 2020/7/5
 */
class TestFragment: BaseDBFragment<TestViewModel, FragmentTestBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_test

//    private val activityVM by lazy {
//        getAppVM<TestViewModel>()
//    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mBinding.viewmodel = mViewModel
        setStatusBarLightMode(true)
    }

}