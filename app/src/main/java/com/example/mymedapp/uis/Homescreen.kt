package com.example.mymedapp.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mymedapp.bootmbar.BtmnavItem
import com.example.mymedapp.bootmbar.Btmnavigate
import com.example.mymedapp.ui.theme.Typography

@Composable
fun homescreen(navcontroller:NavHostController){
var navhost= rememberNavController()
 Scaffold (bottomBar = {
     bottombar(navcontroller = navhost)


 }){
   Box(modifier = Modifier.padding(it)) {
       Btmnavigate(navHostController = navhost)
   }
 }
  //


}
//bottom bar
@Composable
fun bottombar(navcontroller: NavHostController){
    var items= listOf(
        BtmnavItem.Home,
        BtmnavItem.sale,
        BtmnavItem.cart,
        BtmnavItem.profile
    )
   
    BottomNavigation(backgroundColor= Color.White,contentColor=Color.White){
        val navback by navcontroller.currentBackStackEntryAsState()
        val curre = navback?.destination?.route
      items.forEach {
         BottomNavigationItem(
             selected = curre == it.routes.toString(),
             label = {
                 Text(text = it.label,color=if(curre == it.routes)Color.DarkGray else Color.LightGray)
             },
             onClick = { 
                 if(curre !=it.routes){
                     navcontroller.graph?.startDestinationRoute?.let { 
                         navcontroller.popBackStack(it,true)
                     }
                     navcontroller.navigate(it.routes){
                         launchSingleTop=true
                     }
                 }
             },
             icon = { 
                 Icon(imageVector = it.icon, contentDescription = null, tint = if(curre==it.routes)Color.DarkGray else Color.LightGray)
                 
             })
      }
    }
}
//n1
@Composable
fun home(navcontroller: NavHostController){
    var count= remember {
        mutableStateOf("1")
    }
Column(modifier = Modifier
    .fillMaxSize()
    .padding(top = 20.dp)) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .padding(5.dp)) {
        Row(modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)) {
            //card

cartdesign(Icons.Rounded.ShoppingCart,"All Product","0",Color.Magenta)
cartdesign(Icons.Rounded.ShoppingCart,"All Product","0",Color.Cyan)


            }




    }
//
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        Text(text = "Quantity")
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(300.dp), contentAlignment = Alignment.TopEnd
           ) {
            Row(horizontalArrangement = Arrangement.End) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription ="",Modifier.clickable {
                  var c:Int=count.value.toInt()
                  c++
                  count.value=c.toString()
                })
                Card(){
                    Text(text=count.value, style = Typography.bodyLarge)

                }
                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription ="" ,Modifier.clickable {
                    var c:Int=count.value.toInt()
                    if(c>0) {
                        c--

                        count.value = c.toString()
                    }

                })
            }

        }


    }

    }

}

//cart inside home
@Composable
fun cartdesign(logo: ImageVector, title: String, quantity: String, magenta: Color) {
    Card(modifier = Modifier
        .width(200.dp)
        .fillMaxHeight()
        .padding(10.dp)
        .shadow(elevation = 10.dp)
        .clip(shape = RoundedCornerShape(10.dp))) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = logo,
                contentDescription = "",
                tint = magenta,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
            Text(text = title)
            Text(text = quantity)

        }
    }
}
//n2
@Composable
fun sale(navcontroller: NavHostController){

}
//n3
@Composable
fun cart(navcontroller: NavHostController){

}
//n4
@Composable
fun profile(navcontroller: NavHostController){

}


