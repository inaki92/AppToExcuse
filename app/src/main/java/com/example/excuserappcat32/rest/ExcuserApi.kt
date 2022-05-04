package com.example.excuserappcat32.rest

import com.example.excuserappcat32.model.ExcusesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExcuserApi {

    @GET(RANDOM_LIST_EXCUSE)
    suspend fun getListRandomExcuse(
        @Path("excuseNumber") excuseNumber: Int
    ): Response<List<ExcusesItem>>

    @GET(RANDOM_CAT_EXCUSE)
    suspend fun getListRandomExcuseByCategory(
        @Path("excuseNumber") excuseNumber: Int,
        @Path("category") category: String?
    ): Response<List<ExcusesItem>>

    companion object {
        // RANDOM SET OF EXCUSE https://excuser.herokuapp.com/v1/excuse/3
        // RANDOM SET OF CATEGORY EXCUSE https://excuser.herokuapp.com/v1/excuse/college/4
        const val BASE_URL = "https://excuser.herokuapp.com/v1/"
        private const val RANDOM_LIST_EXCUSE = "excuse/{excuseNumber}"
        private const val RANDOM_CAT_EXCUSE = "excuse/{category}/{excuseNumber}"
    }
}