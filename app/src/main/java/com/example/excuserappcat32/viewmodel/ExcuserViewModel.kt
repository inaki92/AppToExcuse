package com.example.excuserappcat32.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.excuserappcat32.rest.ExcuseRepository
import com.example.excuserappcat32.util.UIState
import com.example.excuserappcat32.util.ViewIntentRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExcuserViewModel @Inject constructor(
    private val repository: ExcuseRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _listExcuse: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val excuses: LiveData<UIState> get() = _listExcuse

    fun getListExcuse(actionIntent: ViewIntentRequest) {
        when (actionIntent) {
            is ViewIntentRequest.GetRandomExcuse -> {
                collectRandomExcuse(actionIntent)
            }
            is ViewIntentRequest.GetRandomOfficeExcuse -> {

            }
            is ViewIntentRequest.GetRandomFamilyExcuse -> {

            }
            is ViewIntentRequest.GetRandomCollegeExcuse -> {

            }
        }
    }

    private fun collectRandomExcuse(intentRequest: ViewIntentRequest) {
        viewModelScope.launch(ioDispatcher) {
            repository.getRandomExcuseList(intentRequest).collectLatest {
                _listExcuse.postValue(it)
            }
        }
    }
}