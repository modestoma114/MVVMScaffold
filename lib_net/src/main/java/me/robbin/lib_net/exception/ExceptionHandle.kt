package me.robbin.lib_net.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import java.lang.NumberFormatException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import javax.net.ssl.SSLHandshakeException

/**
 *  错误处理
 * Create by Robbin at 2020/7/23
 */
object ExceptionHandle {

    fun handleException(e: Throwable): ResponseThrowable {
        val ex: ResponseThrowable
        if (e is ResponseThrowable) {
            ex = e
        } else {
            ex = when (e) {
                is HttpException -> {
                    when (e.code()) {
                        ApiResultCode.UNAUTHORIZED,
                        ApiResultCode.FORBIDDEN,
                        ApiResultCode.NOT_FOUND ->
                            ResponseThrowable(e.code().toString(), "网络错误", e)
                        ApiResultCode.GATEWAY_TIMEOUT,
                        ApiResultCode.REQUEST_TIMEOUT ->
                            ResponseThrowable(e.code().toString(), "网络连接超时", e)
                        ApiResultCode.INTERNAL_SERVER_ERROR,
                        ApiResultCode.BAD_GATEWAY,
                        ApiResultCode.SERVICE_UNAVAILABLE ->
                            ResponseThrowable(e.code().toString(), "服务器错误", e)
                        else -> ResponseThrowable(e.code().toString(), "网络错误", e)
                    }
                }
                is JsonParseException, is JSONException, is ParseException ->
                    ResponseThrowable(ApiResultCode.PARSE_ERROR, "解析错误", e)
                is SocketException ->
                    ResponseThrowable(ApiResultCode.REQUEST_TIMEOUT.toString(), "网络连接错误，请重试", e)
                is SocketTimeoutException ->
                    ResponseThrowable(ApiResultCode.REQUEST_TIMEOUT.toString(), "网络连接超时", e)
                is SSLHandshakeException ->
                    ResponseThrowable(ApiResultCode.SSL_ERROR, "证书验证失败", e)
                is UnknownHostException ->
                    ResponseThrowable(ApiResultCode.UNKNOW_HOST, "网络错误，请切换网络重试", e)
                is UnknownServiceException ->
                    ResponseThrowable(ApiResultCode.UNKNOW_HOST, "网络错误，请切换网络重试", e)
                is NumberFormatException ->
                    ResponseThrowable(ApiResultCode.UNKNOW_HOST, "数字格式化错误", e)
                else -> ResponseThrowable(ApiResultCode.UNKNOWN, "未知错误", e)
            }
        }
        return ex
    }

}