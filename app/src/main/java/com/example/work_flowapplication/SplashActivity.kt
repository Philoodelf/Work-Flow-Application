package com.example.work_flowapplication

import android.Manifest
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.app.ActivityCompat
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.POST_NOTIFICATIONS
            ),
            0
        )
        setContent {
            WorkFlowApplicationTheme {

                buttonnav()
                /*
                if (getToken(this)==null) {
                    NavHostSetup(this)
                }
                else{ if (getRole(this)=="admin"){
                 }

                   else{ home(this)}}
*/

            }
        }
    }



            }



/*@Composable
fun splashscreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (logo)=createRefs()
        Image(painter = painterResource(id =R.drawable.logo ), contentDescription ="logo" ,
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.clip(RoundedCornerShape(size = 50.dp))

        )
    }
}*/


/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkFlowApplicationTheme {
        splashscreen()
    }
}*/