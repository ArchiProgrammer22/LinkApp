package com.example.webviewapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webviewapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}