package com.yape.challengeyape.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yape.domain.model.Recipe
import com.yape.domain.usecase.GetDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getDataUseCase: GetDataUseCase) : ViewModel() {
    private val _data = MutableStateFlow<List<Recipe>>(emptyList())
    val data: StateFlow<List<Recipe>> = _data

    fun fetchData() {
        viewModelScope.launch {
            _data.value = getDataUseCase()
        }
    }
}