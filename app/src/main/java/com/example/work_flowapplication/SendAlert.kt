package com.example.work_flowapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SendAlert(
    navController: NavHostController

    ) {

    var title:String
    title = Screens.SendAlert.route.toString()

    Column {


        TextButton(onClick = { },) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color(0xFF029DF0),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(25.dp)

            )
        }
        Box(modifier = Modifier
            .padding(start = 20.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            sendmessage()
        }
        Box(modifier = Modifier
            .padding(start = 50.dp, end = 8.dp, top = 50.dp)
          ,  contentAlignment = Alignment.Center
        ){
            send()
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sendmessage() {
    var text by remember {
        mutableStateOf(" ")
    }

    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color(0xFF029DF0), // Color when the field is focused
        unfocusedBorderColor = Color(0xFF0289f0), // Color when the field is not focused
        cursorColor = Color(0xFF6BC3FF) // Color of the cursor
    )
    OutlinedTextField(

        value = text,
        onValueChange = { text= it},
       colors = textFieldColors,
        label = { Text(text = "Send Alert for all Employees")}
    )

}

@Composable
fun send(
    navController: NavHostController = rememberNavController()
) {
    ElevatedButton(onClick = {  /*TODO*/  navController.popBackStack()  },colors = ButtonDefaults.buttonColors(
         Color(0xFF029DF0)),
        modifier = Modifier.size(width = 300.dp, height = 50.dp)

    ) {
        Text(text = "Send", color = Color.White,
            fontWeight = FontWeight.Medium,
           fontSize = 20.sp
            )
    }
}