package com.reouven.app_using_api_in_view.model.network

import com.reouven.app_using_api_in_view.model.Numbers
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://pastebin.com/raw/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getNumbers] method
 */
interface NumberApiService {
    /**
     * Returns a [Numbers] who compose by a [List] of [Number] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "8wJzytQX" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("8wJzytQX")
    suspend fun getNumbers(): Numbers
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object NumberApi {
    val retrofitService: NumberApiService by lazy { retrofit.create(NumberApiService::class.java) }
}
