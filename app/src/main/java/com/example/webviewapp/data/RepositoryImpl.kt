package com.example.webviewapp.data

import com.example.webviewapp.data.api.AmazonApi
import com.example.webviewapp.domain.Link
import com.example.webviewapp.presentation.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val api: AmazonApi
) : Repository {

    override suspend fun getLink() = api.getLink()
}