package me.robbin.mvvmscaffold.network

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 * 异常处理
 * Create by Robbin at 2020/7/3
 */
object ExceptionHandle {

    fun handleException(e: Throwable?): ResponseThrowable {
        var ex: ResponseThrowable
        e?.let {
            when (it) {
                is HttpException -> {
                    ex = ResponseThrowable(ERROR.HTTP_ERROR, e)
                    return ex
                }
                is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                    ex = ResponseThrowable(ERROR.PARSE_ERROR, e)
                    return ex
                }
                is ConnectException -> {
                    ex = ResponseThrowable(ERROR.NETWORK_ERROR, e)
                    return ex
                }
                is javax.net.ssl.SSLException -> {
                    ex = ResponseThrowable(ERROR.SSL_ERROR, e)
                    return ex
                }
                is java.net.SocketTimeoutException -> {
                    ex = ResponseThrowable(ERROR.TIMEOUT_ERROR, e)
                    return ex
                }
                is java.net.UnknownHostException -> {
                    ex = ResponseThrowable(ERROR.TIMEOUT_ERROR, e)
                    return ex
                }
                else -> {
                    ex = if (!e.message.isNullOrEmpty()) ResponseThrowable(1000, e.message!!, e)
                    else ResponseThrowable(ERROR.UNKNOWN, e)
                }
            }
        }
        ex = ResponseThrowable(ERROR.UNKNOWN, e)
        return ex
    }
}