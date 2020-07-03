package me.robbin.mvvmscaffold.network

/**
 *
 * Create by Robbin at 2020/7/2
 */
interface IBaseResponse<T> {
    fun code(): Int
    fun msg(): String
    fun data(): T
    fun isSuccess(): Boolean
}