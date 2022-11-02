package com.example.webviewapp.di.modules

import com.example.webviewapp.data.RepositoryImpl
import com.example.webviewapp.presentation.Repository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: Repository): RepositoryImpl
}