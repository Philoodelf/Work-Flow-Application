package com.example.work_flowapplication.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage( modifier: Modifier = Modifier) {

      Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(graycolour),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
ConstraintLayout(modifier = Modifier
    .height(250.dp)
    .background(bluecolour)) {
    val (topImg,profile,title,back,pen)=createRefs()

Image(painter = painterResource(id = com.example.work_flowapplication.R.drawable.arcplus), contentDescription = "",
    Modifier
        .fillMaxWidth()
        .constrainAs(topImg) {
            bottom.linkTo(parent.bottom)

        }
    )

    Image(painter = painterResource(id = com.example.work_flowapplication.R.drawable.personimage), contentDescription = "",
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
        modifier = Modifier.constrainAs(title){
            top.linkTo(parent.top, margin = 32.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        )
    Card (   Modifier
        .size(32.dp)
        .constrainAs(back) {
            top.linkTo(parent.top, margin = 36.dp)
            start.linkTo(parent.start, margin = 20.dp)
        }.clickable {}, colors = CardDefaults.cardColors(containerColor = bluecolour)
        ){
        Icon(painter = painterResource(id = com.example.work_flowapplication.R.drawable.profile_arrow),
            contentDescription = "",
            Modifier
                .size(32.dp)
                , tint = white
        )
    }
    Card (   Modifier
        .size(32.dp)
        .constrainAs(pen) {
            top.linkTo(title.top, margin = 8.dp)
            start.linkTo(title.end, margin = 100.dp)
        }.clickable {}, colors = CardDefaults.cardColors(containerColor = bluecolour)
    ){
    Icon(painter = painterResource(id = com.example.work_flowapplication.R.drawable.pen_edit),
        contentDescription = "",
        Modifier
            .size(32.dp)
            , tint = white
    )}
}
          Spacer(modifier = Modifier.height(16.dp))
          Text(
              text = "Esmail Fareed",
              fontSize = 26.sp,
              fontWeight = FontWeight.Bold,
            color = bluecolour
              )

          Text(
              text = "esmailfareed@22gmail.com",
              fontSize = 18.sp,
              fontWeight = FontWeight.Bold,
              color = gg
          )
          Spacer(modifier = Modifier.height(28.dp))
          NotificationItem(icon = com.example.work_flowapplication.R.drawable.informaion, text = "Phone",text2 = "    01098256908" )
          Spacer(modifier = Modifier.height(16.dp))
          NotificationItem(icon = com.example.work_flowapplication.R.drawable.informaion, text = "Address",text2 = " Alexandria")
          Spacer(modifier = Modifier.height(16.dp))
          NotificationItem(icon = com.example.work_flowapplication.R.drawable.informaion, text = "birthDate",text2 = "11-9-2002")
          Spacer(modifier = Modifier.height(16.dp))
          NotificationItem(icon = com.example.work_flowapplication.R.drawable.informaion, text = "Position",text2 = "  Mobile Developer")
          Spacer(modifier = Modifier.height(16.dp))
          NotificationItem(icon = com.example.work_flowapplication.R.drawable.informaion, text = "Location",text2 = " FaculityofScience")
            }
        }


@Composable
fun NotificationItem(icon: Int, text: String, text2: String) {
    Card(
        Modifier
            .fillMaxWidth(0.9f)
            .height(55.dp)
            .clickable {},
        colors = CardDefaults.cardColors(containerColor = white) ,
        border = BorderStroke(2.dp, white)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(24.dp), tint = bluecolour)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = text2, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = gg)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}