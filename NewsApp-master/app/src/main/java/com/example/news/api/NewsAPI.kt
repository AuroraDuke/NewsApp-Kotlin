package com.example.news.api

import com.example.news.models.NewsResponse
import com.example.news.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int =1,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int =1,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>

}