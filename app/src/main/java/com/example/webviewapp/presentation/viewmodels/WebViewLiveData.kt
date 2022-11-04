package com.example.webviewapp.presentation.viewmodels

import android.content.Context
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.LiveData

class WebViewLiveData(
    context: Context,
    private val viewModelUrl: String
) : LiveData<WebView>() {

    private val webView: WebView = WebView(context).apply {
        loadUrl(viewModelUrl)
        settings.javaScriptEnabled = true
        webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false
            }
        }
    }

    override fun onActive() {
        value = webView
    }

    override fun onInactive() {
        webView.detachFromParent()
    }

    private fun WebView.detachFromParent() {
        (parent as? ViewGroup)?.removeView(this)
    }
}