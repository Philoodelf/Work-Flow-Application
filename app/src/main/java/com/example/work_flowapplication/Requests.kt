package com.example.work_flowapplication

import android.graphics.drawable.Icon
import android.icu.util.Calendar.WeekData
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.ui.theme.graycolour

@Composable
fun Request() {
    val context= LocalContext.current.applicationContext
    var title =""
    val showDialog = remember { mutableStateOf(false) }
    val textFieldValue = remember { mutableStateOf("") }
    val currentItem = remember { mutableStateOf<RequestItem?>(null) }

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
val deleteditem = remember {
    mutableStateListOf<RequestItem>()
}
    val items= listOf(
        RequestItem("Ahmed Mohammed", "Programmer", "1 Day", "Sick"," Wed 17 June"," to "," Wed 17 June","Sick"),
        RequestItem("Ali Ashraf", "Front-End", "Swap", ""," Thur 18 June"," to "," Thur 18 June","Swap"),
        RequestItem("Mahmoud Ahmed", "Back-End", "2 Days", "Vacation"," Fri 19 June"," to "," Sun 20 June","Vacation Leave"),
        RequestItem("Mina Samy", "Flutter-Developer", "1 Week", "Injured"," Sat 10 June"," to "," Sat 17 June","Car Accident"),
        RequestItem("Peter Emad", "Sales", "1 Day", "Fest"," Mon 12 June"," to "," Mon 12 June","Day Off"),
    )

Box( modifier = Modifier.background(graycolour) ){
LazyColumn(){
   items(items){

                 //   (name, job, info1, info2,time1,to,time2,conditionof )
       item ->
       AnimatedVisibility(visible = !deleteditem.contains(item),
           enter = expandVertically(),
           exit = shrinkHorizontally(animationSpec = tween(durationMillis = 1000))
           ) {
           


                ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    modifier = Modifier
                        .size(width = 380.dp, height = 160.dp)
                        .padding(start = 20.dp, top = 16.dp)
                        .clickable { "to do" },
                    colors = CardDefaults.cardColors(Color.White)) {
                    //image + name + job
                    Row(modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.requestprofile),
                            contentDescription = "des",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .padding(start = 15.dp, top = 15.dp)
                        )
                        Column() {
                            Text(item.name, fontSize = 15.sp, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(start = 15.dp, top = 15.dp))
                            Text(item.job, fontSize = 10.sp,modifier = Modifier.padding(start = 15.dp, ))
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
                                .clickable { deleteditem.add(item)
                                    Toast.makeText(context, "Accepted Request", Toast.LENGTH_SHORT).show()
                                }) {

                                Image(
                                    painter = painterResource(id = R.drawable.correcticon),
                                    contentDescription = "des",
                                    modifier = Modifier
                                        .size(46.dp)
                                        .padding(8.dp)
                                )

                            }
                            Box(modifier = Modifier.clickable {
                                currentItem.value = item
                                showDialog.value = true

                            }) {
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
                        Row(modifier = Modifier.padding(start = 25.dp),
                            verticalAlignment = Alignment.CenterVertically
                            ) {
                            Icon(
                                Icons.Rounded.DateRange,
                                contentDescription = "icon",
                                tint = Color(0xFF029DF0),
                                modifier = Modifier.size(15.dp)

                            )
                            Text(item.time1, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                             //   modifier = Modifier.padding(bottom = 8.dp)
                                )
                            Text(item.to, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            Text(item.time2, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

                        }

                        Row(modifier = Modifier.padding(start = 24.dp, top = 3.dp),
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Rounded.List,
                                contentDescription = "icon",
                                tint = Color(0xFF029DF0),
                                modifier = Modifier.size(18.dp)
                            )
                            Text(item.conditionof, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)

                        }
                    }
                    // info
                    Row(modifier = Modifier.padding(start = 25.dp, top = 3.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .size(width = 53.dp, height = 21.dp)
                                .padding(bottom = 2.dp)
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
                                    text = item.info1,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        if (item.info2.isNotBlank()){
                            Card(
                                modifier = Modifier
                                    .size(width = 62.dp, height = 21.dp)
                                    .padding(start = 10.dp, bottom = 2.dp)
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
                                        text = item.info2,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }

                    }


                }}
            }
        }}


    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = {
                Text(text = "Delete Request")
            },
            text = {
                Column {
                    Text("Are you sure you want to delete this request?")
                    TextField(
                        value = textFieldValue.value,
                        onValueChange = { textFieldValue.value = it },
                        label = { Text("Reason") }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Handle delete action
                        currentItem.value?.let {
                            deleteditem.add(it)
                            Toast.makeText(context, "Refused Request", Toast.LENGTH_SHORT).show()
                        }
                        showDialog.value = false
                        textFieldValue.value = ""


                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                        textFieldValue.value = ""
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
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