package com.example.newsapp.presentation

import com.example.newsapp.domain.model.Article

data class NewsStateHolder(
    val isLoading:Boolean=false,
    val data:List<Article>?=null,
    val error:String=""

)