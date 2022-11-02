package com.example.webviewapp.presentation

import com.example.webviewapp.domain.Link

interface Repository {
    suspend fun getLink(): Link
}