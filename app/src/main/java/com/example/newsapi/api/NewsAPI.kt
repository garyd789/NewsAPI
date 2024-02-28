package com.example.newsapi.api

import retrofit2.http.GET

private const val API_KEY = "d6a5a2d1b77748ef8db6b02e4f919223"
interface NewsAPI {
    @GET(
        "v2/top-headlines?country=us" +
                "&apiKey=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchNews(): String
}