package me.robbin.mvvmscaffold.base.viewmodel

import androidx.lifecycle.AndroidViewModel
import me.robbin.mvvmscaffold.utils.Utils

/**
 * ViewModel基类
 * Create by Robbin at 2020/6/30
 */
abstract class BaseViewModel(): AndroidViewModel(Utils.getAPP()) {
}