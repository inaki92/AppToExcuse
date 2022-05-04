package com.example.excuserappcat32.util

sealed class UIState {
    object LOADING : UIState()
    data class SUCCESS<T>(val response: T): UIState()
    data class ERROR(val error: Exception): UIState()
}

sealed class ViewIntentRequest(val limit: Int, val categorySent: String? = null) {
    data class GetRandomExcuse(val numberOfExcuse: Int) : ViewIntentRequest(numberOfExcuse)

    data class GetRandomOfficeExcuse(
        val numberOfExcuse: Int,
        val category: ExcuseCategory
        ) : ViewIntentRequest(numberOfExcuse, category.name.lowercase())

    data class GetRandomCollegeExcuse(
        val numberOfExcuse: Int,
        val category: ExcuseCategory
        ) : ViewIntentRequest(numberOfExcuse, category.name.lowercase())

    data class GetRandomFamilyExcuse(
        val numberOfExcuse: Int,
        val category: ExcuseCategory
        ) : ViewIntentRequest(numberOfExcuse, category.name.lowercase())
}

enum class ExcuseCategory {
    OFFICE,
    FAMILY,
    COLLEGE
}
