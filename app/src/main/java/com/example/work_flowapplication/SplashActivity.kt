package com.example.work_flowapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.work_flowapplication.ui.localdata.decodeAndSaveTokenData
import com.example.work_flowapplication.ui.localdata.deleteToken
import com.example.work_flowapplication.ui.localdata.getRole
import com.example.work_flowapplication.ui.localdata.getToken
import com.example.work_flowapplication.ui.localdata.saveToken
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme
import com.example.work_flowapplication.ui.theme.home
import com.example.work_flowapplication.ui.theme.nav
class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkFlowApplicationTheme {

            getToken(this )
                if (getToken(this)==null) {
                    nav(this)
                }
                else{ if (getRole(this)=="admin"){
                    buttonnav()}

                   else{ home(this)}}
           // nav(this)
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