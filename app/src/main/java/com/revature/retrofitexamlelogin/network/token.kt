package com.revature.retrofitexamlelogin.network

import androidx.compose.runtime.MutableState
import com.google.gson.annotations.SerializedName

data class token (

    @SerializedName("accessToken")  val accessToken:String


    )