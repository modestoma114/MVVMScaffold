package me.robbin.mvvmscaffold.demo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.add
import androidx.fragment.app.commit
import me.robbin.mvvmscaffold.base.DataBindingConfig
import me.robbin.mvvmscaffold.base.activity.BaseDBActivity
import me.robbin.mvvmscaffold.demo.databinding.ActivityMainBinding
import me.robbin.mvvmscaffold.utils.setStatusBarTransparent


class MainActivity : BaseDBActivity<TestViewModel, ActivityMainBinding>() {

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_main, BR.viewModel, mViewModel)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setStatusBarTransparent()
    }

    override fun createObserver() {
        mBinding.btn.setOnClickListener {
            setPadding(mBinding.btn)
        }
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