package com.example.work_flowapplication.ui.theme

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.EditemployeeRequest
import com.example.work_flowapplication.ui.api.Editemployeerespond
import com.example.work_flowapplication.ui.localdata.getSecondToken
import com.example.work_flowapplication.ui.localdata.saveSecondToken
import retrofit2.Call
import retrofit2.Response
import java.net.URL

/*

*/

@Composable
fun editProfilePage(navController: NavHostController) {
    val context = LocalContext.current.applicationContext
    val result = remember { mutableStateOf<Uri?>(null) }
    val urlResult = remember { mutableStateOf<URL?>(null) }
    var selectfile by remember {
        mutableStateOf(false)
    }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            result.value = it
            urlResult.value = it?.let { uri -> uriToUrl(uri) }
            selectfile = false
        }


    var text by remember { mutableStateOf("") }
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            colors = CardDefaults.cardColors(containerColor = bluecolour)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding( start = 16.dp)
                        .size(25.dp)
                        .clickable {
                            navController.popBackStack()
                        })

                Spacer(modifier = Modifier.width(8.dp)) // Add space between the icon and the text
                Text(
                    text = "Back",
                    color = Color(0xFF029DF0),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                //    Spacer(modifier = Modifier.width(80.dp))
                Text(
                    text = "  Create User",
                    fontSize = 28.sp,
                    color = white,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp,)
                )
            }
            //  Spacer(modifier = Modifier.height(60.dp))
            Spacer(modifier = Modifier.height(60.dp))

            if (selectfile) {
                // Trigger the image picker
                LaunchedEffect(Unit) {
                    launcher.launch(
                        PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }
            }

            result.value?.let { image ->
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = image)
                        .build()
                )

//                Box(
//                    modifier = Modifier
//                        .fillMaxHeight() // Make the Box fill the available space
//                        .padding(16.dp) // Optional: Add padding if needed
//                ) {
//                    Image(
//                        painter = painter,
//                        contentDescription = "",
//                      //  contentScale = ContentScale.Crop, // Crop the image to fill its bounds
//                        modifier = Modifier
//                            .size(600.dp) // Set the desired size for the image
//                            .align(Alignment.Center) // Center the image within the Box
//                            .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
//                    )
//                }

                Box(
                    modifier = Modifier
                        .width(400.dp)
                        .height(500.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp) // Set the desired size for the image
                            .align(Alignment.Center) // Center the image within the Box
                            .clip(RoundedCornerShape(48.dp)) // Apply rounded corners
                    )
                }
            } ?: run {
//                Box(
//                    modifier = Modifier
//                        .width(400.dp)
//                        .height(500.dp)
//                        .background(Color.LightGray) // Optional: for visualization
                //  ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.proprofile),
//                        contentDescription = "",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(300.dp) // Set size to ensure it fits well within the Box
//                            .align(Alignment.Center)
//                            .clip(RoundedCornerShape(16.dp))
//                    )


                IconButton(
                    onClick = { selectfile = true },
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraEnhance,
                        contentDescription = "Add",
                        tint = bluecolour
                    )
                }
            }
        }
        //}

        Column {
     Spacer(modifier = Modifier.height(16.dp))
     text(text1 = "Name")

     OutlinedTextField(
         value = text,
         onValueChange = { text = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New name",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Email")

     OutlinedTextField(
         value = text1,
         onValueChange = { text1 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Email",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Phone")

     OutlinedTextField(
         value = text2,
         onValueChange = { text2 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Phone",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Position")

     OutlinedTextField(
         value = text3,
         onValueChange = { text3 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Position",
                 fontSize = 15.sp
             )
         },

         )
     text(text1 = "Address")

     OutlinedTextField(
         value = text4,
         onValueChange = { text4 = it },
         modifier = Modifier
             .padding(top = 4.dp)
             .fillMaxWidth(0.9f)
             .height(55.dp),
         shape = RoundedCornerShape(10.dp),
         colors = OutlinedTextFieldDefaults.colors(
             unfocusedBorderColor = textfieldcolour,
             focusedLabelColor = textfieldcolour,
             focusedTextColor = black
         ),
         placeholder = {
             Text(
                 text = "New Address",
                 fontSize = 15.sp
             )
         },

         )
 }
saveSecondToken(context,"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoibWljaGFlbCIsInVzZXJsZCI6IjY1ZmY0NTU2ZDExNWRlNDg2OGIzODg3ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzExMjMxMTQwfQ.Y9m_HY877R6E1_Z3DYxcd2J-W9JVISprQTmbJ2pPjTo")
        val name=text
        val email=text1
        val phone=text2
        val position=text3
        val Address=text4
val role="user"
        val gender="male"
        val birthdate="11-9-2002"
        val image=result.value.toString()
        val socialstatue="single"
        val token:String?="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoibWljaGFlbCIsInVzZXJsZCI6IjY1ZmY0NTU2ZDExNWRlNDg2OGIzODg3ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzExMjMxMTQwfQ.Y9m_HY877R6E1_Z3DYxcd2J-W9JVISprQTmbJ2pPjTo"
        val s =EditemployeeRequest(image,Address,role, gender, phone, name,socialstatue,birthdate,position,email)
        Spacer(modifier = Modifier.height(40.dp))
        TextButton(
            onClick = {
ApiManger.getapiservices().editemployee("66742c4f042c4bd341ed20a6", getSecondToken(context),s).enqueue(object :retrofit2.Callback<Editemployeerespond>{
    override fun onResponse(p0: Call<Editemployeerespond>, p1: Response<Editemployeerespond>) {
        Log.e("tag", "api start.....")
        val rspond = p1.body()
        if (p1.isSuccessful && rspond != null) {
            Log.e("tag", "onResponse: message: ${rspond.user}")
        }
        else {
            hndelerror(p1)
        }
    }
    private fun hndelerror(response:Response<Editemployeerespond>) {
        when (response.code()) {
            401 -> {
                // Handle Unauthorized - token may be invalid or expired
                Log.e("tag", "onResponse: unauthorized, token might be expired or invalid")
                // You can prompt the user to login again or refresh the token
            }
            429 -> {
                // Handle Too Many Requests - rate limiting
                Log.e("tag", "onResponse: too many requests, retry after some time")
                // You can implement a retry mechanism with exponential backoff
            }
            400 -> {
                // Handle Bad Request
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: bad request, error: $errorBody")
            }
            500 -> {
                // Handle Internal Server Error
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: server error, error: $errorBody")
            }
            else -> {
                // Handle other status codes
                val errorBody = response.errorBody()?.string()
                Log.e("tag", "onResponse: error, code: ${response.code()}, error: $errorBody")
            }
        }
    }

    override fun onFailure(p0: Call<Editemployeerespond>, p1: Throwable) {



    }
})

            }, modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(1.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
        ) {

            Text(
                text = "Update",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = white
            )

        }
    }

    }

@Composable
fun text(text1:String){
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = text1, fontSize = 18.sp, fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 4.dp))
}
@Composable
 fun edit( text:String){
Column( ) {
    Text(text =text)
    Spacer(modifier = Modifier.height(8.dp))

}


 }
@Preview()
@Composable
fun Profw() {

}

