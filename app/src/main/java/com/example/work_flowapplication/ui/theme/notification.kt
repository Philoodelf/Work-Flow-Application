package com.example.work_flowapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.work_flowapplication.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@Composable
fun Notifications(navController: NavHostController) {

//        Box(modifier = Modifier.fillMaxSize()){
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//            Text(text = "Report", fontSize = 30.sp)
//        }
//    }
    Box(modifier = Modifier)
    var refreshing by remember { mutableStateOf(false) }
    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(3000)
            refreshing = false
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = { refreshing = true },
    ) {

        // list view
        val items = listOf(
            theitems("Emily Johnson", "Has Singed in", R.drawable.reportprofile!!),
            theitems("Liam Smith", "Has Left", R.drawable.proprofile!!),
            theitems("Noah Davis", "Logged out", R.drawable.requestprofile!!),
            theitems("Philopater Odolf", "Updated Profile", R.drawable.philo!!),
            theitems("Michael Magdy", "Completed a new task", R.drawable.michael!!),
            theitems("Esmail Farid", "Completed a project", R.drawable.esmail!!),
            theitems("Mason Taylor", "Changed password", R.drawable.requestprofile!!),
            theitems("Lucas Harris", "Location Changed", R.drawable.requestprofile!!),
            theitems("Alexander Clark", "Reminder", R.drawable.requestprofile!!),
            theitems("Ethan Wilson", "Reminder", R.drawable.requestprofile!!),
        )




        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
                TextButton(
                    onClick = { navController.popBackStack() },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color(0xFF029DF0),
                        contentDescription = "Back",
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add space between the icon and the text
                    Text(
                        text = "Back",
                        color = Color(0xFF029DF0),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }

            LazyColumn() {
                items(items) { (name, job, profile) ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        modifier = Modifier
                            .size(width = 380.dp, height = 100.dp)
                            .padding(start = 20.dp, top = 16.dp)
                            .clickable { "to do" },
                        colors = CardDefaults.cardColors(Color.White)
                    ) {

                        Row(modifier = Modifier) {
                            Image(
                                painter = painterResource(id = profile),
                                contentDescription = "Profile Picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .padding(start = 15.dp, top = 15.dp)
                            )
                            Column(modifier = Modifier.padding(15.dp)) {
                                Text(name, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                                Text(job, fontSize = 15.sp)
                            }
                        }

                    }
                }
            }

        }

    }
}

data class theitems(
    val name: String,
    val job: String,
    val profile: Int,

    )

@Composable
fun pulltorefreshh() {

}