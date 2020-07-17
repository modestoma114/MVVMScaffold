package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import me.robbin.mvvmscaffold.base.activity.BaseDBActivity
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.demo.databinding.ActivityMainBinding
import me.robbin.mvvmscaffold.ext.viewmodel.getAppVM
import me.robbin.mvvmscaffold.utils.StatusBarUtils
import me.robbin.mvvmscaffold.utils.setStatusBarTransparent
import me.robbin.mvvmscaffold.utils.toToast


class MainActivity : BaseDBActivity<BaseViewModel, ActivityMainBinding>() {

    private val appViewModel by lazy { getAppVM<TestViewModel>() }

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun initVariable() {
        mBinding.viewmodel = appViewModel
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        supportFragmentManager.commit {
            add<TestFragment>(R.id.fragment_container).addToBackStack("${System.currentTimeMillis()}")
        }
        setStatusBarTransparent()
        StatusBarUtils.getStatusBarHeight().toToast()
    }

    override fun createObserver() {
        mBinding.btn.setOnClickListener {
            setPadding(mBinding.btn)
        }
    }

    private val TAG_OFFSET = "TAG_OFFSET"
    private val KEY_OFFSET = -123

    private fun setBottomMargin(view: View, bottom: Int) {
        val lp = view.layoutParams as (ViewGroup.MarginLayoutParams)
        lp.setMargins(0, 0, 0, bottom)
        view.layoutParams = lp
        "HaHa".toToast()
        view.requestLayout()
    }

    private fun setPadding(view: View) {
        val lp = view.layoutParams
        if (lp != null && lp.height > 0) {
            lp.height += 30 //增高
        }
        view.setPadding(
            view.paddingLeft, view.paddingTop + 30,
            view.paddingRight, view.paddingBottom
        )
    }

}