package com.example.webviewapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.webviewapp.UtilConstants
import com.example.webviewapp.data.local.dao.LinkDao
import com.example.webviewapp.data.local.database.LinkDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context): LinkDao {
        return Room.databaseBuilder(
            context,
            LinkDatabase::class.java,
            UtilConstants.DB_NAME
        ).build().linkDao()
    }
}