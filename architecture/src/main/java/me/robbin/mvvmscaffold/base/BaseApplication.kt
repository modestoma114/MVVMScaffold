package me.robbin.mvvmscaffold.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import me.robbin.mvvmscaffold.utils.Utils

/**
 * Application 基类，获取应用级的 ViewModel 以及初始化工具类
 * Create by Robbin at 2020/7/1
 */
abstract class BaseApplication : Application(), ViewModelStoreOwner {

    private lateinit var mAppViewModelStore: ViewModelStore

    private var mFactory: ViewModelProvider.Factory? = null

    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }

    @Synchronized
    fun setApplication(@NonNull application: Application) {
        mAppViewModelStore = ViewModelStore()
        Utils.init(application)
        application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AppManager.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                AppManager.removeActivity(activity)
            }
        })
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }

    /**
     * 获取一个全局的ViewModel
     */
    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory as ViewModelProvider.Factory
    }

}