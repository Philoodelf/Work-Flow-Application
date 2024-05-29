package com.example.work_flowapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.ui.theme.graycolour

@Composable
fun Request( modifier: Modifier) {
    var title =""
    title = Screens.Requests.route.toString()
//    Box(modifier = Modifier.fillMaxSize()){
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//            Text(text = title, fontSize = 30.sp)
//
//        }
//    }

    val items= listOf(
        RequestItem("Davina Cornish", "Programmer", "1 Day", "Sick"," Wed 17 June"," to "," Wed 17 June","Sick"),
        RequestItem("Sam Dino", "Front-End", "Swap", ""," Thur 18 June"," to "," Thur 18 June","Swap"),
        RequestItem("Mark Scot", "Back-End", "2 Days", "Vacation"," Fri 19 June"," to "," Sun 20 June","Vacation Leave"),
        RequestItem("Mario Guy", "Flutter-Developer", "1 Week", "Injured"," Sat 10 June"," to "," Sat 17 June","Car Accident"),
        RequestItem("Peter Patrick", "Sales", "1 Day", "Fest"," Mon 12 June"," to "," Mon 12 June","Day Off"),
    )

Box(modifier.background(graycolour) ){
LazyColumn(){
   items(items){

    (name, job, info1, info2,time1,to,time2,conditionof ) ->

       ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    modifier = Modifier
        .size(width = 380.dp, height = 150.dp)
        .padding(start = 32.dp, top = 16.dp)
        .clickable { "to do" },
    colors = CardDefaults.cardColors(Color.White)) {
    //image + name + job
    Row(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.requestprofile),
            contentDescription = "des",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .padding(start = 15.dp, top = 15.dp)
        )
        Column(modifier = Modifier.padding(15.dp)) {
            Text(name, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            Text(job, fontSize = 10.sp)
        }

        Spacer(modifier = Modifier.weight(1f))
//            Icon(
//                Icons.Rounded.CheckCircle,
//                contentDescription = "no",
//                tint = Color(0xFF34A853),
//                modifier = Modifier.size(50.dp).padding(start = 4.dp, end = 4.dp)
//            )
        Box(
            modifier = Modifier.padding(end = 16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Box(modifier = Modifier
                .padding(end = 38.dp, top = 4.dp)
                .clickable { /*to do*/ }) {

                Image(
                    painter = painterResource(id = R.drawable.correcticon),
                    contentDescription = "des",
                    modifier = Modifier
                        .size(46.dp)
                        .padding(8.dp)
                )

            }
            Box(modifier = Modifier.clickable { /*to do*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.xicon),
                    contentDescription = "des",
                    modifier = Modifier
                        .size(52.dp)
                        .padding(8.dp)
                )
            }


        }
    }
    // date + time + info
    Column {
        Row(modifier = Modifier.padding(start = 25.dp, top = 5.dp)) {
            Icon(
                Icons.Rounded.DateRange,
                contentDescription = "icon",
                tint = Color(0xFF029DF0),
                modifier = Modifier.size(15.dp)
            )
            Text(time1, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            Text(to, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            Text(time2, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

        }

        Row(modifier = Modifier.padding(start = 24.dp, top = 5.dp)) {
            Icon(
                Icons.Rounded.List,
                contentDescription = "icon",
                tint = Color(0xFF029DF0),
                modifier = Modifier.size(18.dp)
            )
            Text(conditionof, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

        }
    }
    // info
    Row(modifier = Modifier.padding(start = 25.dp, top = 5.dp)
    ) {
        Card(
            modifier = Modifier
                .size(width = 53.dp, height = 21.dp)
                .wrapContentWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color(0xFFECEDF1))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = info1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        if (info2.isNotBlank()){
            Card(
                modifier = Modifier
                    .size(width = 62.dp, height = 21.dp)
                    .padding(start = 10.dp)
                    .wrapContentWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(0xFFECEDF1))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = info2,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
    }

    }


}
}
}}




    }

data class RequestItem(
    val name: String,
    val job: String,
    val info1: String,
    val info2: String,
    val time1: String,
    val to: String,
    val time2: String,
    val conditionof: String,

)

