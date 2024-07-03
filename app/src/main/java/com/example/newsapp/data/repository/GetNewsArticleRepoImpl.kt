package com.example.newsapp.data.repository

import com.example.newsapp.common.SafeApiRequest
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsArticleRepository
import com.example.newsapp.mappers.toDomain
import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService):
    NewsArticleRepository, SafeApiRequest() {

    override suspend fun getNewsArticles(): List<Article> {
        val response= safeApiRequest { apiService.getNewsArticles() }
        return response.articles?.toDomain()!!
    }
}