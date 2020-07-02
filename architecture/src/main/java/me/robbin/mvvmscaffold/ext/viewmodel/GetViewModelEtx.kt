package me.robbin.mvvmscaffold.ext.viewmodel

import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import me.robbin.mvvmscaffold.base.BaseApplication

/**
 * 获取当前类绑定的ViewModel
 * Create by Robbin at 2020/7/1
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVMCls(cls: Any): VM {
    return (cls.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}

/**
 * 在Activity中获取应用级别的ViewModel
 * Create by Robbin at 2020/7/1
 */
inline fun <reified VM : BaseViewModel> AppCompatActivity.getAppVM(): VM {
    (this.application as? BaseApplication).let {
        if (it == null) {
            throw NullPointerException("You didn't initialize BaseApplication!")
        } else {
            return it.getAppViewModelProvider()[VM::class.java]
        }
    }
}

/**
 * 在Fragment中获取应用级别的ViewModel
 * Create by Robbin at 2020/7/1
 */
inline fun <reified VM: BaseViewModel> Fragment.getAppVM(): VM {
    (this.requireActivity().application as? BaseApplication).let {
        if (it == null) {
            throw NullPointerException("You didn't initialize BaseApplication!")
        } else {
            return it.getAppViewModelProvider()[VM::class.java]
        }
    }
}