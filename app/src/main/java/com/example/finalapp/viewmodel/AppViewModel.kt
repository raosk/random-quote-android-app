package com.example.finalapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.model.ModelDataClass
import com.example.finalapp.model.QuoteApi
import kotlinx.coroutines.launch

sealed interface AppUIState {
    data class Success(val quotes: List<ModelDataClass>): AppUIState
    object Error: AppUIState
    object Loading: AppUIState
}

class AppViewModel: ViewModel() {
    var appUIState: AppUIState by mutableStateOf(AppUIState.Loading)
        private set

    init {
        getQuoteList()
    }

    private  fun getQuoteList() {
        viewModelScope.launch {
            var quoteApi: QuoteApi?
            try {
                quoteApi = QuoteApi!!.getInstance()
                appUIState = AppUIState.Success(quoteApi.getQuote())
            } catch (e: Exception) {
                Log.d("VIEWMODEL", e.message.toString())
                appUIState = AppUIState.Error
            }
        }
    }
}