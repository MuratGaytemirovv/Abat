package com.weeprogram.abat.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://dbpedia.org/data/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface LanguageApiService {
    @GET("Chechen_language.json")
    suspend fun getDescriptions(): Language
}

object LanguageApi {
    val retrofitService : LanguageApiService by lazy {
        retrofit.create(LanguageApiService::class.java) }
}