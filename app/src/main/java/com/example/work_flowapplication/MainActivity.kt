package com.example.work_flowapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkFlowApplicationTheme {
                // A surface container using the 'background' color from the theme
                splashscreen()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   
                }
            }
        }
    }
}

@Composable
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
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkFlowApplicationTheme {
        splashscreen()
    }
}