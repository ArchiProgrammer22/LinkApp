package com.example.webviewapp

import android.app.Application
import com.example.webviewapp.di.components.AppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

}