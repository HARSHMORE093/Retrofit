package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news =NewsService.newsInstance.getbitcoin("bitcoin",1)
//        enqueue matlab queue mai rahege ek ke baad ek response mai aate jayenge
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if(news != null){
                    Log.d("Harsh ",news.toString())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Harsh","Error in fecthing!")
            }

        })
    }
}