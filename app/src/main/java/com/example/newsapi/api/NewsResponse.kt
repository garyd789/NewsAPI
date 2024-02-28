package com.example.newsapi.api


data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)