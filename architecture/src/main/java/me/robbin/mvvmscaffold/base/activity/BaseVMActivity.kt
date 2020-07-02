package me.robbin.mvvmscaffold.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import me.robbin.mvvmscaffold.base.IBaseView
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.ext.viewmodel.getVMCls

/**
 * Activity 基类（使用 ViewModel ）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseVMActivity<VM : BaseViewModel> : AppCompatActivity(),
    IBaseView {

    private lateinit var mViewModel: VM

    // 判断是否使用 DataBinding
    private var useDB = false

    // 视图文件
    protected abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!useDB) {
            setContentView(layoutRes())
        } else {
            initDataBinding()
        }
        mViewModel = createViewModel()
        initView(savedInstanceState)
        initData()
        createObserver()
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun createObserver() {
    }

    /**
     * 创建 ViewModel
     * Create by Robbin at 2020/7/1
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVMCls(this))
    }

    /**
     * 获取 Activity 级别的 ViewModel
     * Create by Robbin at 2020/7/2
     */
    protected fun getViewModel(): VM {
        return mViewModel
    }

    protected fun useDataBinding(use: Boolean) {
        useDB = use
    }

    /**
     * 初始化 DataBinding
     * Create by Robbin at 2020/7/1
     */
    open fun initDataBinding() {}

}