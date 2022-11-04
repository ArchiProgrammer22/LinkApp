package com.example.webviewapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.webviewapp.UtilConstants
import com.example.webviewapp.domain.Link
import com.example.webviewapp.presentation.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getLink(): LiveData<Link> {
        return liveData(Dispatchers.IO) { emit(repository.getLink()) }
    }

    fun getLocalLink(): LiveData<Link> {
        return liveData(Dispatchers.IO) { emit(repository.getLocalLink()) }
    }

    fun insertLocalLink(link: Link) {
        viewModelScope.launch(Dispatchers.IO) { repository.insertLocalLink(link) }
    }

    fun isItFirstTime(): Boolean {
        val edit = repository.getLocalData().edit()
        if (repository.getLocalData().getBoolean(UtilConstants.FIRST, true)) {
            edit.putBoolean(UtilConstants.FIRST, false)
            edit.apply()
            return true
        }
        return false
    }
}