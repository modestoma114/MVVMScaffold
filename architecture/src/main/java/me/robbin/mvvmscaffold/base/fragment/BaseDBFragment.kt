package me.robbin.mvvmscaffold.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel

/**
 * Fragment 基类（使用 ViewModel 和 DataBinding）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseDBFragment<VM : BaseViewModel, VDB : ViewDataBinding> : BaseVMFragment<VM>() {

    protected lateinit var mBinding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

}