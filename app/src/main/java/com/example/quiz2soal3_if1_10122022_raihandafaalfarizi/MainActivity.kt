package com.example.quiz2soal3_if1_10122022_raihandafaalfarizi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.adapter.HeroAdapter
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.model.DataItem
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.model.ResponseUser
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.network.ApiConfig
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    /*
    Quiz 2 Parsing API Publik
    10122022
    Raihan Dafa Alfarizi
    IF1*/
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroAdapter(mutableListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.rv_user)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getUser()

    }

    private fun getUser() {
        val client = ApiConfig.getApiService().getListUsers("1")

        client.enqueue(object : retrofit2.Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {

                if (response.isSuccessful) {
                    val dataArray = response.body()?.data as List<DataItem>
                    for (data in dataArray) {
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }

        })
    }
}