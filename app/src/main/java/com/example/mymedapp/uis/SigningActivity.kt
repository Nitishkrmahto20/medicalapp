package com.example.mymedapp.uis

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Looper.getMainLooper
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mymedapp.R
import com.example.mymedapp.nav.Routes
import com.example.mymedapp.viewmodelsitem.SignupViewModel
import kotlin.math.sign

@Composable
fun Signin(navController: NavHostController, signinmodel: SignupViewModel) {
    var useremail = remember {
        mutableStateOf("")
    }
    var userpassword = remember {
        mutableStateOf("")

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //logo
        Image(painterResource(id = R.drawable.logo), modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(bottom = 40.dp), contentDescription = "")
//email
        Card(
            modifier = Modifier
                .background(Color.White)
                .shadow(elevation = 10.dp, ambientColor = DefaultShadowColor)
        ) {
            Row(modifier = Modifier.background(Color.White)) {
                Image(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(5.dp)
                )
                OutlinedTextField(
                    value = useremail.value,
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, color = Color.White),
                    onValueChange = { useremail.value = it },
                    placeholder = {
                        Text(text = "Enter your mail")
                    })
            }

        }
Spacer(modifier = Modifier.height(10.dp))
        //passwordtext
        Card(
            modifier = Modifier
                .background(Color.White)
                .shadow(elevation = 10.dp, ambientColor = DefaultShadowColor)
        ) {
            Row(modifier = Modifier.background(Color.White)) {
                Image(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(5.dp)
                )
                OutlinedTextField(
                    value = useremail.value,
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, color = Color.White),
                    onValueChange = { userpassword.value = it },
                    placeholder = {
                        Text(text = "Enter your Password")
                    })
            }

        }
        //space
Spacer(modifier = Modifier.height(10.dp))
        //button
        OutlinedButton(onClick = {navController.navigate(Routes.Homescreen.toString())  }, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
           ) {
            Text(text = "Sign In")

        }
        Text(text = "Or")
        Text(text = "Signup", modifier = Modifier
            .clickable {
                navController.navigate(Routes.signup.toString())
            }
            .padding(10.dp))


    }


}

@Composable
fun SignUp(navController: NavHostController, signmodel: SignupViewModel,context:Context) {
var username= remember {
    mutableStateOf("")
}
    var phoneno= remember {
        mutableStateOf("")
    }
    var email= remember {
        mutableStateOf("")
    }
    var address= remember {
        mutableStateOf("")
    }
    var pincode= remember {
        mutableStateOf("")
    }
    var password= remember {
        mutableStateOf("")
    }
    var btntxt="Signup"
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Please fill properly", modifier = Modifier.padding(top = 40.dp))

        //
        Spacer(modifier = Modifier.height(60.dp))
       Textboxes(username,"username",Icons.Rounded.Person)
        Spacer(modifier = Modifier.height(10.dp))
       Textboxes(email,"email",Icons.Rounded.Email)
        Spacer(modifier = Modifier.height(10.dp))
       Textboxes(phoneno,"phoneno",Icons.Rounded.Phone)
        Spacer(modifier = Modifier.height(10.dp))
       Textboxes(address,"address",Icons.Rounded.LocationOn)
        Spacer(modifier = Modifier.height(10.dp))
       Textboxes(password,"password",Icons.Rounded.Lock)
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedButton(onClick = {
            checkValidation(username.value,email.value,phoneno.value,address.value,password.value,context,signmodel)
navController.navigate(Routes.Homescreen.toString())

        }) {
            Text(text = btntxt)

        }


        }







}

fun checkValidation(
    username: String,
    email: String,
    phone: String,
    address: String,
    password: String,
    context: Context,
    signvmodel: SignupViewModel
){
    var check=false

    if(username.isEmpty()||email.isEmpty()||phone.isEmpty()||address.isEmpty()||password.isEmpty()){
        Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show()

    }
    else{

        Toast.makeText(context, "all ok", Toast.LENGTH_SHORT).show()
    }


}



@Composable
fun Textboxes(fields: MutableState<String>, s: String,icon:ImageVector) {

    Card(
        modifier = Modifier
            .background(Color.White)
            .shadow(elevation = 10.dp, ambientColor = DefaultShadowColor)
    ) {
        Row(modifier = Modifier.background(Color.White)) {
            Image(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value =fields .value,
                modifier = Modifier
                    .background(Color.White)
                    .border(1.dp, color = Color.White),
                onValueChange = { fields.value = it },
                placeholder = {
                    Text(text = "Enter your ${s}")
                })
            Spacer(modifier = Modifier.height(10.dp))
            //
        }
    }
}

@Composable
fun Welcome(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Image(
            painterResource(id = R.drawable.pay), contentDescription = "", modifier = Modifier
                .fillMaxSize()
                .padding(100.dp), alignment = Alignment.Center
        )
        android.os.Handler(getMainLooper()).postDelayed({

            navController.navigate(Routes.signin.toString())


        }, 2000)
    }



}

