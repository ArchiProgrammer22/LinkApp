package com.example.webviewapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.webviewapp.domain.Link
import com.example.webviewapp.presentation.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getLink(): LiveData<Link> {
        return liveData(Dispatchers.IO) {
            val data = repository.getLink()
            emit(data)
        }
    }
}