package com.example.newsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.common.Resource
import com.example.newsapp.domain.usecase.NewsArticleUseCase
import com.example.newsapp.presentation.NewsStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: NewsArticleUseCase) :
    ViewModel() {

    val articles = mutableStateOf(NewsStateHolder())


    init {
        getNewsArticles()
    }

    fun getNewsArticles(){
        getNewsArticleUseCase().onEach {
            when(it){
                is Resource.Loading->{
                    articles.value = NewsStateHolder(isLoading = true)
                }
                is Resource.Success->{
                    articles.value = NewsStateHolder(data = it.data)
                }
                is Resource.Error->{
                    articles.value = NewsStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }



}