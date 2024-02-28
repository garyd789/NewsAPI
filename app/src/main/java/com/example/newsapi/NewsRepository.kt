package com.example.newsapi

import com.example.newsapi.api.NewsAPI
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class NewsRepository {
    private val newsAPI: NewsAPI
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        newsAPI = retrofit.create()
    }
    suspend fun fetchContents() = newsAPI.fetchNews()
}