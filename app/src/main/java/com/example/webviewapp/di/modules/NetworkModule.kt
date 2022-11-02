package com.example.webviewapp.di.modules

import com.example.webviewapp.UtilConstants
import com.example.webviewapp.data.api.AmazonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApi(): AmazonApi {
        return Retrofit.Builder()
            .baseUrl(UtilConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AmazonApi::class.java)
    }
}