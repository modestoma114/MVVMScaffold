package me.robbin.mvvmscaffold.network

/**
 *
 * Create by Robbin at 2020/7/23
 */
class ResponseThrowable(val code: String, val errMsg: String, val e: Throwable? = null): Exception(e)