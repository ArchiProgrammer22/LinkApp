package com.example.webviewapp.presentation

import android.content.SharedPreferences
import com.example.webviewapp.domain.Link

interface Repository {
    suspend fun getLink(): Link
    suspend fun getLocalLink(): Link
    suspend fun insertLocalLink(link: Link)
    fun getLocalData(): SharedPreferences
}