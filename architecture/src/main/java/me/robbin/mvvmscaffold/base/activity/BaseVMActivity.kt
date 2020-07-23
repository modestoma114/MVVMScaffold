package me.robbin.mvvmscaffold.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.robbin.mvvmscaffold.base.IBaseView
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.ext.viewmodel.getVMCls
import me.robbin.mvvmscaffold.utils.toToast

/**
 * Activity 基类（使用 ViewModel ）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseVMActivity<VM : BaseViewModel> : AppCompatActivity(),
    IBaseView {

    protected lateinit var mViewModel: VM

    // 视图文件
    protected abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
        if (getLayoutRes() != -1) {
            setContentView(getLayoutRes())
            init(savedInstanceState)
        }
    }

    private fun init(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        registerUIEvent()
        createObserver()
        initData()
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

    override fun initData() {
    }

    /**
     * 创建 ViewModel
     * Create by Robbin at 2020/7/1
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVMCls(this))
    }

    /**
     * 注册 UI 事件
     * Create by Robbin at 2020/7/3
     */
    private fun registerUIEvent() {
        mViewModel.uiEvent.showLoading.observe(this, Observer {
            showLoading()
        })
        mViewModel.uiEvent.dismissLoading.observe(this, Observer {
            dismissLoading()
        })
        mViewModel.uiEvent.toastEvent.observe(this, Observer {
            it.toToast()
        })
    }

    /**
     * 打开Loading
     * Create by Robbin at 2020/7/3
     */
    open fun showLoading() {}

    /**
     * 关闭Loading
     * Create by Robbin at 2020/7/3
     */
    open fun dismissLoading() {}

}