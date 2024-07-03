package com.example.newsapp.domain.repository
import com.example.newsapp.domain.model.Article

interface NewsArticleRepository {
    suspend fun getNewsArticles(): List<Article>
}