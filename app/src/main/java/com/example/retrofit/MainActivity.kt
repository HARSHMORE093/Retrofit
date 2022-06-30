package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        val news =NewsService.newsInstance.getbitcoin("bitcoin",1)
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if (news != null) {
                    val recycle = findViewById<RecyclerView>(R.id.recycler)
                    recycle.layoutManager = LinearLayoutManager(this@MainActivity)
                    recycle.setHasFixedSize(true)
                    recycle.adapter=adapter
                    adapter = MyAdapter(this@MainActivity, news.articles)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

            }

        })
    }
}
