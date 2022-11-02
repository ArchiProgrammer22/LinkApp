package com.example.webviewapp.data.api

import com.example.webviewapp.domain.Link
import retrofit2.http.GET

interface AmazonApi {
    @GET("/prod")
    suspend fun getLink(): Link
}