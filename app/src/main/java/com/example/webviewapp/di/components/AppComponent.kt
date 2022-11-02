package com.example.webviewapp.di.components

import com.example.webviewapp.di.modules.NetworkModule
import com.example.webviewapp.di.modules.RepositoryModule
import com.example.webviewapp.presentation.fragments.WebViewFragment
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(webViewFragment: WebViewFragment)
}