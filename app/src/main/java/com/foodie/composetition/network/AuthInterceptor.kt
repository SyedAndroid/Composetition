package com.foodie.composetition.network

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val urlBuilder: HttpUrl.Builder = originalRequest.url.newBuilder()
        val baseUrlBuilder =
            " https://secure-apir.viamichelin.com/apir/2/findPoi.JSON2/RESTAURANT/".toHttpUrlOrNull()
        val request: Request.Builder = originalRequest.newBuilder()
            .header("Accept", "application/json")


        val url: HttpUrl.Builder = urlBuilder.scheme(baseUrlBuilder!!.scheme)
            .addQueryParameter("100", "50")
            .addQueryParameter("dist", distance)
            .addQueryParameter("source", source)
            .addQueryParameter("charset", "UTF-8")
            .addQueryParameter("ie", "UTF-8")
            .addQueryParameter("authKey", "RESTGP20200918151241761650365069")
            .addQueryParameter("orderBy", "RESGR.michelin_stars:desc")

        request.method(originalRequest.method, originalRequest.body)
        request.url(url.build())

        return chain.proceed(request.build())
    }

    companion object {
        const val source = "RESGR"
        const val distance = "10000"

    }

}