package com.example.newsapi

import com.example.newsapi.api.Article
import com.example.newsapi.api.NewsAPI
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory


class NewsRepository {
    private val newsAPI: NewsAPI

    init {
        val gson = GsonBuilder()
            .setLenient() // Optional: if you want to be more lenient about JSON parsing
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create(gson)) // Use GsonConverterFactory
            .build()

        newsAPI = retrofit.create(NewsAPI::class.java) // Specify the class of your API interface
    }

    suspend fun fetchContent(): List<Article> =
        newsAPI.fetchNews().articles
}