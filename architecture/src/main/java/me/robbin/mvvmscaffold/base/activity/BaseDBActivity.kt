package me.robbin.mvvmscaffold.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel

/**
 * Activity 基类（使用 ViewModel 和 DataBinding ）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseDBActivity<VM : BaseViewModel, VDB : ViewDataBinding> : BaseVMActivity<VM>() {

    private lateinit var mBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        useDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, layoutRes())
        mBinding.lifecycleOwner = this
    }

    protected fun getBinding(): VDB {
        return mBinding
    }

}