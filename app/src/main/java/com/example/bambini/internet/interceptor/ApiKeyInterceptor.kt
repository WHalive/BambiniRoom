package com.example.bambini.internet.interceptor

import okhttp3.Interceptor
import okhttp3.Response


class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .addHeader("bf-api-key", "nAdCsZsfxD2wRZFL")
            .build()

        return chain.proceed(newRequest)
    }
}