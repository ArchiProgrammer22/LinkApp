package com.example.webviewapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webviewapp.domain.Link

@Dao
interface LinkDao {
    @Query("SELECT * FROM link")
    fun getLocalLink(): Link

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(link: Link)
}