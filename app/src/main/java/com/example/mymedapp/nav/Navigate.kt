package com.example.mymedapp.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mymedapp.uis.SignUp
import com.example.mymedapp.uis.Signin
import com.example.mymedapp.uis.Welcome
import com.example.mymedapp.uis.homescreen
import com.example.mymedapp.viewmodelsitem.SignupViewModel

@Composable
 fun navigate(navcontroller: NavHostController, viewModel:SignupViewModel,context:Context){
     NavHost(navController = navcontroller, startDestination =Routes.welcome.toString() ){
composable(Routes.signin.toString()){
Signin(navController = navcontroller, signinmodel = SignupViewModel())

}
         composable(Routes.signup.toString()){
             SignUp(navController = navcontroller, signmodel = SignupViewModel(),context)
         }
         composable(Routes.welcome.toString()){
             Welcome(navController = navcontroller)
         }
         composable(Routes.Homescreen.toString()){
             homescreen(navcontroller = navcontroller)
         }
     }

 }