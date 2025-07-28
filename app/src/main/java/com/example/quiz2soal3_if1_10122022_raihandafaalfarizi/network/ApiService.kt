package com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.network
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.model.DataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{id}")
    suspend fun getSuperhero(@Path("id") id: String): Response<DataItem>

    // Tambahkan endpoint lain di sini jika ada
}