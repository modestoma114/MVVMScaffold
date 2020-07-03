package me.robbin.mvvmscaffold.network

/**
 * 自定义错误异常
 * Create by Robbin at 2020/7/2
 */
class ResponseThrowable : Exception {

    var code: Int
    var errMsg: String

    constructor(error: ERROR, e: Throwable? = null) : super(e) {
        code = error.getKey()
        errMsg = error.getValue()
    }

    constructor(code: Int, msg: String?, e: Throwable? = null) : super(e) {
        this.code = code
        this.errMsg = msg ?: "请求失败，请稍后再试"
    }

    constructor(base: IBaseResponse<*>, e: Throwable? = null) : super(e) {
        this.code = base.code()
        this.errMsg = base.msg()
    }
}