package com.example.work_flowapplication.ui.theme

import BiometricManage
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_flowapplication.R

@Composable

fun clockin( context:AppCompatActivity){
    val biometricManage = BiometricManage()
    Column(modifier = Modifier
        .background(graycolour)
        .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome ! Ahmed", fontSize = 22.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 49.dp),
color = Color(0xFF1A1D21)
            )
        Box(modifier = Modifier
            .size(250.dp)
            .padding(top = 44.dp)
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF3893E4), Color(0xFF94C4F2))
                ), shape = CircleShape
            ).clickable {
                biometricManage.authenticateWithBiometrics(context)
            }
        ){
            Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = R.drawable.click_icon) , contentDescription ="" ,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(114.dp), tint = white)
                Text(text = "CLOCK IN", modifier = Modifier.padding(top=12.dp), color = white, fontSize = 22.sp)
            }

        }
        Text(text = "Location : Faculty of Science" ,modifier = Modifier
            .padding(top = 40.dp), fontSize =18.sp,color = Color(0xFF1A1D21)
        )
        Row (modifier = Modifier
            .padding(top = 55.dp, start = 20.dp)
            .fillMaxWidth()
            .height(140.dp)){
            Column( ) {
                Icon(painter = painterResource(id = R.drawable.clockin_logo) , contentDescription ="" ,
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 14.dp),tint = bluecolour)
                Text(text = " 09:10", Modifier
                    .padding(start = 5.dp),fontSize = 18.sp,color = Color(0xFF1A1D21)
                )
                Text(text = "Clock in",fontSize = 18.sp,color = Color(0xFF1A1D21)
                )

            }
            Column( modifier = Modifier
                .padding( start = 50.dp)) {
                Icon(painter = painterResource(id = R.drawable.clockout_logo) , contentDescription ="" ,
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 14.dp),tint = bluecolour)
                Text(text = " 03:10", Modifier
                    .padding(start = 5.dp),fontSize = 18.sp,color = Color(0xFF1A1D21)
                )
                Text(text = "Clock Out",fontSize = 18.sp,color = Color(0xFF1A1D21)
                )

            }
            Column(modifier = Modifier
                .padding( start = 50.dp) ) {
                Icon(painter = painterResource(id = R.drawable.workinghour_logo) , contentDescription ="" ,
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 17.dp),tint = bluecolour)
                Text(text = " 06:10", Modifier
                    .padding(start = 5.dp),fontSize = 18.sp,color = Color(0xFF1A1D21)
                )
                Text(text = "Work Hrs",fontSize = 18.sp,color = Color(0xFF1A1D21)
                )

            }
        }

    }


}
@Composable
@Preview
fun clockinpreview(){

}