package com.example.newsapp.domain.usecase

import com.example.newsapp.common.Resource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsArticleUseCase @Inject constructor(private val getNewsArticleRepo: NewsArticleRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading(""))
        try{
            emit(Resource.Success(getNewsArticleRepo.getNewsArticles()))

        }catch (e:Exception){
            emit(Resource.Error(e.message))
        }

    }

}