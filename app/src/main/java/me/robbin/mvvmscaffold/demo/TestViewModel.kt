package me.robbin.mvvmscaffold.demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel
import me.robbin.mvvmscaffold.utils.toToast

/**
 *
 * Create by Robbin at 2020/7/1
 */
class TestViewModel(): BaseViewModel() {

    private val number: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    fun add() {
        if (number.value == null) {
            number.value == 0
        }
        number.value = number.value?.plus(1)
    }

    fun getNum(): LiveData<Int> {
        return number
    }

}