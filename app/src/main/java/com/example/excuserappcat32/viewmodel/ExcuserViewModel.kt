package com.example.excuserappcat32.viewmodel

import androidx.lifecycle.ViewModel
import com.example.excuserappcat32.rest.ExcuseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExcuserViewModel @Inject constructor(
    private val repository: ExcuseRepository
) : ViewModel() {


}