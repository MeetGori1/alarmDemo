package com.example.fakeuserapicall.retrofit


import com.example.alarmmanager.AllUserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getData(): Response<List<AllUserModel>>



}