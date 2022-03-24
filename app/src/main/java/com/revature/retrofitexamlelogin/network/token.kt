package com.revature.retrofitexamlelogin.network

import com.google.gson.annotations.SerializedName

data class token (

    @SerializedName("accessToken")  val accessToken:String


    )