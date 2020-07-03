package me.robbin.mvvmscaffold.base

import android.app.Activity
import androidx.fragment.app.Fragment
import java.lang.Exception
import java.util.*

/**
 * Activity管理,可使得在任何地方退出应用
 * Create by Robbin at 2020/7/2
 */
object AppManager {

    var activityStack: Stack<Activity> = Stack()
        private set
    var fragmentStack: Stack<Fragment> = Stack()
        private set

    /**
     * 添加Activity到堆栈
     * Create by Robbin at 2020/7/2
     */
    fun addActivity(activity: Activity?) {
        activityStack.add(activity)
    }

    /**
     * 从Activity堆栈中移除制定Activity
     * Create by Robbin at 2020/7/2
     */
    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
        }
    }

    /**
     * 获取当前Activity
     * Create by Robbin at 2020/7/2
     */
    fun currentActivity(): Activity? {
        return activityStack.lastElement()
    }

    /**
     * 结束当前Activity
     * Create by Robbin at 2020/7/2
     */
    fun finishActivity() {
        val activity = activityStack.lastElement()
        activity.finish()
    }

    /**
     * 结束指定Activity
     * Create by Robbin at 2020/7/2
     */
    fun finishActivity(activity: Activity?) {
        activity?.finish()
    }

    /**
     * 结束指定类名的Activity
     * Create by Robbin at 2020/7/2
     */
    fun finishActivity(cls: Class<*>) {
        run breaking@ {
            activityStack.forEach {
                if (it.javaClass == cls) {
                    finishActivity(it)
                    return@breaking
                }
            }
        }
    }

    /**
     * 结束所有Activity
     * Create by Robbin at 2020/7/2
     */
    fun finishAllActivity() {
        activityStack.forEach {
            if (it != null) {
                finishActivity(it)
            }
        }
        activityStack.clear()
    }

    /**
     * 杀死App
     * Create by Robbin at 2020/7/2
     */
    fun killApp() {
        try {
            finishAllActivity()
        } catch (e: Exception) {
            activityStack.clear()
            e.printStackTrace()
        }
    }

}