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

