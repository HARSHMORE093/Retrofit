package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//    https://newsapi.org/v2/everything?q=bitcoin&apiKey=c624dfcc1d294aacb516f64dee519a2d
const val Base_url = "https://newsapi.org/v2/"
const val ApiKey = "c624dfcc1d294aacb516f64dee519a2d"

interface NewsInterface {
    @GET("everything?&apiKey=$ApiKey")
    fun getbitcoin (@Query ("q") q:String,@Query("page") page:Int ):Call<News>

}
object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
