package com.example.newsapp.data.network

import com.example.newsapp.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=eefbbfe55de3484d9ff66e18885097bb
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String ="us",
        @Query("apiKey") apiKey: String ="eefbbfe55de3484d9ff66e18885097bb",
    ): Response<NewsDTO>

 }