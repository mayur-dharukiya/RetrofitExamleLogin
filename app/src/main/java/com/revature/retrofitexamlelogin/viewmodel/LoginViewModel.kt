package com.revature.retrofitexamlelogin.viewmodel

import android.media.session.MediaSession
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.retrofitexamlelogin.network.Login
import com.revature.retrofitexamlelogin.network.repository.RetrofitHelper
import com.revature.retrofitexamlelogin.network.token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val loginRequestLiveData=MutableLiveData<Boolean>()
    var requestToken= mutableStateOf(value=false)



    fun login(email:String,password:String)
    {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val authService=RetrofitHelper.getAuthService()

                val responseService=authService.getLogin(Login(email=email,password=password))

                if(responseService.isSuccessful)
                {
                    responseService.body()?.let { token ->

                        Log.d("Logging Success","Response Token $token")
                        requestToken.value=true

                    }
                }
                else
                {

                    responseService.errorBody()?.let {error->

                        Log.d("Logging Error","Response Token $error")

                        error.close()

                    }
                }



            loginRequestLiveData.postValue(responseService.isSuccessful)
            }
            catch(e:Exception)
            {
                Log.d("Network Exception Log"," Exception in Networking $e")
            }
        }
    }
}