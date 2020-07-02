package me.robbin.mvvmscaffold.demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.robbin.mvvmscaffold.base.viewmodel.BaseViewModel

/**
 *
 * Create by Robbin at 2020/7/1
 */
class TestViewModel: BaseViewModel() {

    private val user: MutableLiveData<String> = MutableLiveData()

    fun getString(): LiveData<String> {
        if (user.value == null) {
            loadString()
        }
        return user
    }

    private fun loadString() {
        user.value = "Hello World!"
    }

}