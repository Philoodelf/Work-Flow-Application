package com.example.work_flowapplication.ui.theme

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.work_flowapplication.R

@Composable
fun editProfilePage(navController: NavController) {
    val context = LocalContext.current.applicationContext
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(250.dp)
                .background(bluecolour)
        ) {
            val (topImg, profile, title, back, pen) = createRefs()

            Image(painter = painterResource(id = R.drawable.arcplus), contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        bottom.linkTo(parent.bottom)

                    }
            )

            Image(painter = painterResource(id = R.drawable.personimage), contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(topImg.bottom)

                    }
            )
            Text(
                text = "Profile",
                fontSize = 30.sp,
                color = white,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Icon(
                painter = painterResource(id = R.drawable.profile_arrow),
                contentDescription = "",
                Modifier
                    .size(32.dp)
                    .constrainAs(back) {
                        top.linkTo(parent.top, margin = 36.dp)
                        start.linkTo(parent.start, margin = 20.dp)
                    }, tint = white
            )

        }
 Column {
     Spacer(modifier = Modifier.height(16.dp))
     text(text1 = "Name")
     var text by remember { mutableStateOf("") }
     OutlinedTextField(
         value = text,
         onValueChange = { text = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New name",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Email")
     var text1 by remember { mutableStateOf("") }
     OutlinedTextField(
         value = text1,
         onValueChange = { text1 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Email",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Phone")
     var text2 by remember { mutableStateOf("") }
     OutlinedTextField(
         value = text2,
         onValueChange = { text2 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Phone",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Position")
     var text3 by remember { mutableStateOf("") }
     OutlinedTextField(
         value = text3,
         onValueChange = { text3 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Position",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Address")
     var text4 by remember { mutableStateOf("") }
     OutlinedTextField(
         value = text4,
         onValueChange = { text4 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Address",
                 fontSize = 15.sp
             )
         },

         )
 }
        Spacer(modifier = Modifier.height(40.dp))
        TextButton(
            onClick = {


            }, modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(1.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
        ) {

            Text(
                text = "Update",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = white
            )

        }
    }

    }

@Composable
fun text(text1:String){
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = text1, fontSize = 18.sp, fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 4.dp))
}
@Composable
 fun edit( text:String){
Column( ) {
    Text(text =text)
    Spacer(modifier = Modifier.height(8.dp))

}


 }

@Preview(showBackground = true)
@Composable
fun editProfilePagePreview() {

}