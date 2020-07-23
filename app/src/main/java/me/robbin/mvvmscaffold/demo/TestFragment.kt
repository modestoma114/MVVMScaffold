package me.robbin.mvvmscaffold.demo

import androidx.fragment.app.activityViewModels
import me.robbin.mvvmscaffold.base.DataBindingConfig
import me.robbin.mvvmscaffold.base.fragment.BaseDBFragment
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.demo.databinding.FragmentTestBinding

/**
 *
 * Create by Robbin at 2020/7/5
 */
class TestFragment : BaseDBFragment<BaseViewModel, FragmentTestBinding>() {

    private val testViewModel by activityViewModels<TestViewModel>()

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_test, BR.viewModel, testViewModel)
    }

}