package me.robbin.mvvmscaffold.base

import android.os.Bundle

/**
 * 视图基类
 * Create by Robbin at 2020/7/1
 */
interface IBaseView {

    /**
     * 初始化界面
     * Create by Robbin at 2020/7/1
     */
    fun initView(savedInstanceState: Bundle?)

    /**
     * 创建数据观察者
     * Create by Robbin at 2020/7/1
     */
    fun createObserver()

    /**
     * 数据请求
     * Create by Robbin at 2020/7/1
     */
    fun initData()

    fun initVariable()

}