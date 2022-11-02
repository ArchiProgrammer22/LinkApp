package com.example.webviewapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Link(
    @PrimaryKey
    val home: String,
    val link: String,
)
