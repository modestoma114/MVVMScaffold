package me.robbin.mvvmscaffold.base.activity

import android.os.Bundle
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.robbin.mvvmscaffold.base.DataBindingConfig
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel

/**
 * Activity 基类（使用 ViewModel 和 DataBinding ）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseDBActivity<VM : BaseViewModel, VDB : ViewDataBinding> : BaseVMActivity<VM>() {

    protected lateinit var mBinding: VDB

    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun getLayoutRes(): Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getDataBindingConfig().getLayout())
        mBinding.lifecycleOwner = this
        mBinding.setVariable(
            getDataBindingConfig().getVmVariableId(),
            getDataBindingConfig().getStateViewModel()
        )
        val bindingParams = getDataBindingConfig().getBindingParams()
        bindingParams.forEach { key, value ->
            mBinding.setVariable(key, value)
        }
        initView(savedInstanceState)
    }

}