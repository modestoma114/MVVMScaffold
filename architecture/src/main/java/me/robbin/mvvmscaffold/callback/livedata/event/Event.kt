package me.robbin.mvvmscaffold.callback.livedata.event

/**
 * 配合 MutableLiveData & EventViewModel 的使用
 * Create by Robbin at 2020/7/2
 */
class Event<T>(private val content: T?) {
    private var hasHandled = false
    fun getContent(): T? {
        if (hasHandled) {
            return null
        }
        hasHandled = true
        return content
    }

}