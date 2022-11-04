package com.example.webviewapp.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class WebViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {

    private lateinit var liveData: WebViewLiveData

    fun setUrl(url: String) {
        if (::liveData.isInitialized) return
        liveData = WebViewLiveData(context, url)
    }

    fun getWebView() = liveData

    fun hasHistory(): Boolean {
        if (liveData.value?.canGoBack()!!) {
            liveData.value?.goBack()
            return true
        }
        return false
    }
}