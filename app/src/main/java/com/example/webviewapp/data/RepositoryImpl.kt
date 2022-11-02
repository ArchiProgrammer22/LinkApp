package com.example.webviewapp.data

import com.example.webviewapp.data.api.AmazonApi
import com.example.webviewapp.presentation.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: AmazonApi
) : Repository {

    override suspend fun getLink() = withContext(Dispatchers.IO) {
        api.getLink()
    }
}