package com.example.work_flowapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.R









@Composable


fun app(){


    var imageid = arrayOf(

        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage

    )
    var description = arrayOf(
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum ",
        "Lorem ipsum dolor sit amet Ex reiciendis eveniet aut quia reiciendis qui distinctio quisquam est rerum "
    )
    var startdate = arrayOf(
        "18-1-2024",
        "18-1-2024",
        "18-1-2024",
        "18-1-2024"

    )
    var endtdate = arrayOf(
        "18-1-2024",
        "18-1-2024",
        "18-1-2024",
        "18-1-2024"

    )
    mytask(imageid,description,startdate,endtdate)

}
@Composable
fun mytask( imageid :Array<Int>,
            description:Array<String>,
            startdate:Array<String>,
            enddate:Array<String>,) {
Surface(modifier =Modifier.fillMaxSize(), color = graycolour) {
    LazyColumn(){
        val count = imageid.size
        items(count){item ->
            task(indexitem =item ,image =imageid,Description=description,
                Startdate=startdate,Enddate=enddate)


        }



    }
}



}


@Composable

fun task(
indexitem:Int,
    image :Array<Int>,
         Description:Array<String>,
         Startdate:Array<String>,
         Enddate:Array<String>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour)
    ) {

        Card(
            modifier = Modifier
                .width(340.dp)
                .height(170.dp).padding(top=32.dp, start = 15.dp)
                .clip(RoundedCornerShape(10.dp))
                , colors = CardDefaults.cardColors(white),
            elevation = CardDefaults.cardElevation(15.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,) {
                Row(
                    modifier = Modifier.padding(top = 13.dp, start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = image[indexitem]),
                        contentDescription = "",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = Description[indexitem].toString(),
                        fontSize = 11.sp, color = black, fontWeight = FontWeight.Medium,
                        maxLines = 2

                    )

                }

                Row(modifier = Modifier.padding(top = 10.dp, start = 20.dp),) {
                    Box(
                        modifier = Modifier
                            .width(91.dp)
                            .height(15.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFFECEDF1))
                    ) {
                        Spacer(modifier = Modifier.width(40.dp))
                        Row(

                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Icon(
                                painter = painterResource(id = R.drawable.calender_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(top = 4.dp, start = 2.dp), tint = black
                            )
                            Text(
                                text = Startdate[indexitem],
                                modifier = Modifier
                                    .width(51.dp)
                                    .height(10.dp)
                                    .padding(start = 4.dp),
                                fontSize = 9.sp
                            )

                        }
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.task_arrow),
                        contentDescription = "",
                        modifier = Modifier
                            .width(25.dp)
                            .height(13.dp)
                            .padding(top = 4.dp, start = 2.dp), tint = black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .width(91.dp)
                            .height(15.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFFECEDF1))
                    ) {
                        Row(
                            modifier = Modifier.padding(start = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.calender_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(top = 4.dp, start = 2.dp), tint = black
                            )
                            Text(
                                text = Enddate[indexitem],
                                modifier = Modifier
                                    .width(51.dp)
                                    .height(10.dp)
                                    .padding(start = 4.dp),
                                fontSize = 9.sp
                            )

                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = { }, modifier = Modifier

                        .height(30.dp)
                        .width(195.dp)
                        .clip(RoundedCornerShape(1.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
                ) {
                    Text(text = "View", fontSize = 12.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(30.dp).height(15.dp)
                        )

                }


            }


        }


    }
}


@Composable
@Preview
fun taskpreview(){

    app()


}








