package com.example.excuserappcat32.rest

import com.example.excuserappcat32.util.UIState
import com.example.excuserappcat32.util.ViewIntentRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ExcuseRepository {
    fun getRandomExcuseList(request: ViewIntentRequest): Flow<UIState>
    fun getCategorizedRandomExcuse(request: ViewIntentRequest): Flow<UIState>
}

class ExcuseRepositoryImpl @Inject constructor(
    private val serverApi: ExcuserApi
) : ExcuseRepository {

    override fun getRandomExcuseList(request: ViewIntentRequest): Flow<UIState> = flow {
        emit(UIState.LOADING)

        try {
            val response = serverApi.getListRandomExcuseByCategory(request.limit, request.categorySent)
        } catch (e: Exception) {

        }
    }

    override fun getCategorizedRandomExcuse(request: ViewIntentRequest): Flow<UIState> {
        TODO("Not yet implemented")
    }

}