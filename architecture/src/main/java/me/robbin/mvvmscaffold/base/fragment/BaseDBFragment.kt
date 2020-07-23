package me.robbin.mvvmscaffold.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.robbin.mvvmscaffold.base.DataBindingConfig
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel

/**
 * Fragment 基类（使用 ViewModel 和 DataBinding）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseDBFragment<VM : BaseViewModel, VDB : ViewDataBinding> : BaseVMFragment<VM>() {

    protected lateinit var mBinding: VDB

    override fun getLayoutRes(): Int = -1

    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, getDataBindingConfig().getLayout(), container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.setVariable(
            getDataBindingConfig().getVmVariableId(),
            getDataBindingConfig().getStateViewModel()
        )
        val bindingParams = getDataBindingConfig().getBindingParams()
        bindingParams.forEach { key, value ->
            mBinding.setVariable(key, value)
        }
        return mBinding.root
    }

}