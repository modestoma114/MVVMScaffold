package me.robbin.mvvmscaffold.utils

import android.app.Activity
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment

/**
 *
 * Create by Robbin at 2020/7/15
 */
object StatusBarUtils {

    fun setStatusBarTransparent(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            val option =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            val vis = activity.window.decorView.systemUiVisibility
            activity.window.decorView.systemUiVisibility = option or vis
            activity.window.statusBarColor = Color.TRANSPARENT
        } else {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    fun setStatusBarLightMode(activity: Activity, isLightMode: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView: View = activity.window.decorView
            var vis = decorView.systemUiVisibility
            vis = if (isLightMode) {
                vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            decorView.systemUiVisibility = vis
        }
    }

    fun getStatusBarHeight(): Int {
        val resources: Resources = Resources.getSystem()
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

}

fun Activity.setStatusBarTransparent() {
    StatusBarUtils.setStatusBarTransparent(this)
}

fun Activity.setStatusBarLightMode(isLightMode: Boolean) {
    StatusBarUtils.setStatusBarLightMode(this, isLightMode)
}

fun Fragment.setStatusBarLightMode(isLightMode: Boolean) {
    StatusBarUtils.setStatusBarLightMode(this.requireActivity(), isLightMode)
}