package com.example.newsapp.domain.di

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repository.GetNewsArticleRepoImpl
import com.example.newsapp.domain.repository.NewsArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class) //remains untill application
@Module
object DomainModule {

    @Provides
    fun provideGetNewsRepo(apiService: ApiService): NewsArticleRepository {
        return GetNewsArticleRepoImpl(apiService)
    }


}