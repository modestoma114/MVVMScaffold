package me.robbin.mvvmscaffold.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import me.robbin.mvvmscaffold.base.IBaseView
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.ext.viewmodel.getVMCls

/**
 * Fragment 基类（使用 ViewModel）
 * Create by Robbin at 2020/6/30
 */
abstract class BaseVMFragment<VM : BaseViewModel> : Fragment(),
    IBaseView {

    //是否需要懒加载
    private var lazyFlag = true

    protected lateinit var mViewModel: VM

    private lateinit var mActivity: AppCompatActivity

    /**
     * 视图文件
     * Create by Robbin at 2020/7/2
     */
    protected abstract val layoutRes: Int

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        initVariable()
        initView(savedInstanceState)
        createObserver()
        initData()
    }

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED && lazyFlag) {
            lazyLoad()
            lazyFlag = false
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun createObserver() {
    }

    protected fun lazyLoad() {
    }

    override fun initVariable() {
    }

    /**
     * 创建 ViewModel
     * Create by Robbin at 2020/7/2
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVMCls(this))
    }

}