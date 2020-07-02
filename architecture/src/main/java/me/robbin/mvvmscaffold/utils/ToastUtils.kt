package me.robbin.mvvmscaffold.utils

import android.widget.Toast

/**
 * Toast工具类
 * Create by Robbin at 2020/7/2
 */
fun String.toToast(duration: Int = Toast.LENGTH_SHORT) {
    showToast(this, duration)
}

fun Int.toToast(duration: Int = Toast.LENGTH_SHORT) {
    showToast(this.toString(), duration)
}

fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(Utils.getAPP(), msg, duration).show()
}