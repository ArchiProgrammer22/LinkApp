package com.example.webviewapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.webviewapp.data.local.dao.LinkDao
import com.example.webviewapp.domain.Link

@Database(entities = [Link::class], version = 1)
abstract class LinkDatabase : RoomDatabase() {
    abstract fun linkDao(): LinkDao
}