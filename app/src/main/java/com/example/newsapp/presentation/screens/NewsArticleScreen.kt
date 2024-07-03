package com.example.newsapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.presentation.viewmodel.NewsViewModel

@Composable
fun NewsArticleScreen(viewModel: NewsViewModel = hiltViewModel()) {
    val res = viewModel.articles.value

    Box(modifier = Modifier.fillMaxSize().padding(5.dp)) {
        when {
            res.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            res.error.isNotBlank() -> {
                Text(
                    text = res.error,
                    style = TextStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.align(Alignment.Center).padding(16.dp)
                )
            }
            res.data != null -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(res.data) { article ->
                        NewsArticleItem(article)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

