package me.robbin.lib_net.exception

/**
 *
 * Create by Robbin at 2020/7/23
 */
class ResponseThrowable(val code: String, val msg: String, val e: Throwable): Exception(e)