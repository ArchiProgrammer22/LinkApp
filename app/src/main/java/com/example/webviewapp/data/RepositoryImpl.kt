package com.example.webviewapp.data

import android.content.SharedPreferences
import com.example.webviewapp.data.api.AmazonApi
import com.example.webviewapp.data.local.dao.LinkDao
import com.example.webviewapp.domain.Link
import com.example.webviewapp.presentation.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val api: AmazonApi,
    private val dao: LinkDao,
    private val sharedPreferences: SharedPreferences
) : Repository {

    override suspend fun getLink() = api.getLink()
    override suspend fun getLocalLink() = dao.getLocalLink()
    override suspend fun insertLocalLink(link: Link) = dao.insert(link)
    override fun getLocalData() = sharedPreferences
}