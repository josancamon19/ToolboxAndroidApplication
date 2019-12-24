package com.josancamon19.toolboxtestapp.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josancamon19.toolboxtestapp.models.AuthRequest
import com.josancamon19.toolboxtestapp.models.AuthResponse
import com.josancamon19.toolboxtestapp.models.Carousel
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

const val BASE_URL = "https://echo-serv.tbxnet.com/v1/mobile/"

val retrofit: Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient.Builder().addInterceptor(run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply { level = HttpLoggingInterceptor.Level.BODY }
        }).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

interface ApiProvider {

    @POST("auth")
    fun authAsync(@Body request: AuthRequest): Deferred<AuthResponse>


    @GET("data")
    fun getCarouselsAsync(@Header("Authorization") token: String): Deferred<List<Carousel>>


}

object ToolBoxApi {
    val retrofitService: ApiProvider by lazy { retrofit.create(ApiProvider::class.java) }
}