package me.robbin.mvvmscaffold.network

import me.robbin.mvvmscaffold.utils.Utils
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *
 * Create by Robbin at 2020/7/11
 */
open class RetrofitClient {

    companion object {
        val instance: RetrofitClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitClient()
        }
    }

    private val httpClient: OkHttpClient
        get() {
            var builder = OkHttpClient.Builder()
            builder = setHttpClient(builder)
            return builder.build()
        }

    open fun setHttpClient(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.apply {
            cache(Cache(File(Utils.getAPP().cacheDir, "app_cache"), 10 * 1024 * 1024))
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
        return builder
    }

    fun <T> getApi(baseUrl: String, service: Class<T>): T {
        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
        return setRetrofit(builder).build().create(service)
    }

    open fun setRetrofit(builder: Retrofit.Builder): Retrofit.Builder {
        builder.addConverterFactory(GsonConverterFactory.create())
        return builder
    }

}