package me.robbin.mvvmscaffold.demo

import me.robbin.mvvmscaffold.base.BaseApplication
import me.robbin.mvvmscaffold.utils.toToast

/**
 *
 * Create by Robbin at 2020/7/2
 */
class App: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        "Hello".toToast()
    }

}