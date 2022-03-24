package com.revature.retrofitexamlelogin.network.repository

import com.revature.retrofitexamlelogin.network.Login
import com.revature.retrofitexamlelogin.network.token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {


    @POST("auth")
    suspend fun getLogin(@Body login: Login):Response<token>

}