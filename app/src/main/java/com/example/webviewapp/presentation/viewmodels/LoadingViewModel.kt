package com.example.webviewapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.webviewapp.domain.Link
import com.example.webviewapp.presentation.Repository
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getLink(): LiveData<Link> {
        return liveData { emit(repository.getLink()) }
    }
}