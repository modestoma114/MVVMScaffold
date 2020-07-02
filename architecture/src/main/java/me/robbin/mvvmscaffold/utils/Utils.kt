package me.robbin.mvvmscaffold.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.lang.reflect.InvocationTargetException

/**
 * Utils
 * Create by Robbin at 2020/7/1
 */
object Utils{

    private lateinit var sApplication: Application

    /**
     * 初始化工具类
     * Create by Robbin at 2020/7/1
     */
    fun init(context: Context) {
        init((context as Application).applicationContext)
    }

    /**
     * 初始化工具类
     * Create by Robbin at 2020/7/1
     */
    fun init(app: Application) {
        if (!::sApplication.isInitialized) {
            sApplication = app
        }
    }

    /**
     * 获得Application上下文
     * Create by Robbin at 2020/7/1
     */
    fun getAPP(): Application {
        if (::sApplication.isInitialized) {
            return sApplication
        }
        val app =getApplicationByReflect()
        init(app)
        return app
    }

    private fun getApplicationByReflect(): Application {
        try {
            @SuppressLint("PrivateApi") val activityThread =
                Class.forName("android.app.ActivityThread")
            val thread = activityThread.getMethod("currentActivityThread").invoke(null)
            val app = activityThread.getMethod("getApplication").invoke(thread)
                ?: throw NullPointerException("u should init first")
            return app as Application
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        throw NullPointerException("u should init first")
    }

}