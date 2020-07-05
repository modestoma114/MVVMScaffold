package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import me.robbin.mvvmscaffold.base.fragment.BaseDBFragment
import me.robbin.mvvmscaffold.base.viewmodel.NoViewModel
import me.robbin.mvvmscaffold.demo.databinding.FragmentTestBinding
import me.robbin.mvvmscaffold.ext.viewmodel.getAppVM

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
    }

}