package com.example.excuserappcat32.rest

import okhttp3.Interceptor
import okhttp3.Response

class MyRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder()
            .addHeader("FIRST_HEADER", "FIRST")
            .addHeader("SECOND_HEADER", "SECOND")
            .addHeader("THIRD_HEADER", "THIRD")
            .build()
            .apply {
                return chain.proceed(this)
            }
    }
}
