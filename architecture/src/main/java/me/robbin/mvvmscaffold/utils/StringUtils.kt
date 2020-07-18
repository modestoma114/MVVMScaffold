package me.robbin.mvvmscaffold.utils

/**
 *
 * Create by Robbin at 2020/7/18
 */
fun String.isSpace(): Boolean {
    if (this == null)
        return true
    this.forEach {
        if (!Character.isWhitespace(it))
            return false
    }
    return true
}