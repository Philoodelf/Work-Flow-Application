package com.example.work_flowapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile() {
//    Box(modifier = Modifier.fillMaxSize()){
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//          //  Text(text = "Profile", fontSize = 30.sp)
//        }
//    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){

        //profile
        Box(){
            Image(
                painter = painterResource(id = R.drawable.proprofile),
                contentDescription = "des",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(start = 15.dp, top = 15.dp)
            )
        }

        Column(modifier = Modifier) {

            //name

                Text(text = "Name",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                )
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF5F6FA),
                    ),
                    border = BorderStroke(0.8.dp, Color.Gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(40.dp)
                        .padding(start = 12.dp, end = 12.dp)
                ) {
                    Text(
                        text = "Mr.George",
                        fontWeight = FontWeight.Medium ,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 7.dp),
                        textAlign = TextAlign.Center,
                    )
                }



            //Email


                Text(text = "Email",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                )
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF5F6FA),
                    ),
                    border = BorderStroke(0.8.dp, Color.Gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(40.dp)
                        .padding(start = 12.dp, end = 12.dp)
                ) {
                    Text(
                        text = "George@gmail.com",
                        fontWeight = FontWeight.Medium ,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 7.dp),
                        textAlign = TextAlign.Center,
                    )
                }

            //Phone

            Text(text = "Phone",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Text(
                    text = "+20|1205****84",
                    fontWeight = FontWeight.Medium ,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 7.dp),
                    textAlign = TextAlign.Center,
                )
            }

            //address

            Text(text = "Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
            )
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F6FA),
                ),
                border = BorderStroke(0.8.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Text(
                    text = "31 st. Madinat Al Amal\nNew Cairo, Egypt",
                    fontWeight = FontWeight.Medium ,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp),
                    textAlign = TextAlign.Center,
                )
            }

            //Gender

            Row() {
                Text(text = "Gender",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp, )
                )
                Text(text = "Birth Date",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 100.dp, top = 20.dp, )
                )

            }

            Row(modifier = Modifier.padding(start = 16.dp)) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF029DF0),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(15.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
                
                Text(text = "Male" ,fontWeight = FontWeight.Normal ,
                    modifier = Modifier
                        .padding(start = 8.dp,),
//                    textAlign = TextAlign.Center,
                )

                Text(text = "20 May 2002" ,fontWeight = FontWeight.Light ,
                    modifier = Modifier
                        .padding(start = 100.dp,),
                )




                
            }


        }

    }


}