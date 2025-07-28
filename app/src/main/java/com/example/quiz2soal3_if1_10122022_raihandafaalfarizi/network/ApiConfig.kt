package com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ACCESS_TOKEN = "f77ec049ae87a8c9b8b31464591daef0"
private const val BASE_URL = "https://superheroapi.com/api/$ACCESS_TOKEN/"

class ApiConfig{
    companion object {
        val api: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
