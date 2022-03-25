package com.revature.retrofitexamlelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.revature.retrofitexamlelogin.ui.LoginView
import com.revature.retrofitexamlelogin.ui.theme.RetrofitExamleLoginTheme
import com.revature.retrofitexamlelogin.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    private val viewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExamleLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    LoginView(viewModel=viewModel)
                }
            }
        }
    }
}
