package com.example.mymedapp.bootmbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mymedapp.uis.cart
import com.example.mymedapp.uis.home
import com.example.mymedapp.uis.profile
import com.example.mymedapp.uis.sale


@Composable
fun  Btmnavigate(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BtmnavItem.Home.routes){
      composable(BtmnavItem.Home.routes.toString()) {
          home(navcontroller = navHostController)
      }
        composable(BtmnavItem.sale.routes.toString()){
            sale(navcontroller = navHostController)
        }
        composable(BtmnavItem.cart.routes.toString()){
            cart(navcontroller = navHostController)
        }

        composable(BtmnavItem.profile.routes.toString()){
            profile(navcontroller = navHostController)
        }

    }
}