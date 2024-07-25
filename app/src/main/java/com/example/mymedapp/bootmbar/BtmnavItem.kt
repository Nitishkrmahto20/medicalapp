package com.example.mymedapp.bootmbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BtmnavItem(var icon:ImageVector,val label:String,var routes:String) {
    object Home: BtmnavItem(icon=Icons.Rounded.Home,label="home","Home")
    object sale: BtmnavItem(Icons.Rounded.Refresh,"sale","sale")
    object cart: BtmnavItem(Icons.Rounded.ShoppingCart,"cart","cart")
    object profile: BtmnavItem(Icons.Rounded.Person,"profile","profile")


}