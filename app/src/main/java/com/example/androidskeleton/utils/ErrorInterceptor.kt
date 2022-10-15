package com.example.androidskeleton.utils

import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.net.ssl.SSLHandshakeException

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        try {
            val response = chain.proceed(request)
            val bodyString = response.body!!.string()

            return response.newBuilder()
                .body(bodyString.toResponseBody(response.body?.contentType()))
                .build()
        } catch (e: Exception) {
            var msg = "Error getting data"
            var interceptorCode: Int = 0

            when (e) {
                is SocketTimeoutException -> {

                    msg = "Socket timeout error"
                    interceptorCode = 408

                }
                is HttpException -> {
                    msg = "Http error"
                    interceptorCode = 404
                }
                is SSLHandshakeException ->{
                    msg = "Chain validation failed"
                    interceptorCode = 404
                }
                else -> {
                    msg = "Unable to reach server"
                    interceptorCode = 0
                }


            }

            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(interceptorCode)
                .message(msg)
                .body("{${e}}".toResponseBody(null)).build()
        }
    }
}