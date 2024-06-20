package com.example.work_flowapplication.ui.theme

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.work_flowapplication.R
import com.example.work_flowapplication.Screens
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.LoginRequest
import com.example.work_flowapplication.ui.api.LoginResponse
import com.example.work_flowapplication.ui.localdata.decodeAndSaveTokenData
import com.example.work_flowapplication.ui.localdata.getRole
import com.example.work_flowapplication.ui.localdata.saveToken
import retrofit2.Call
import retrofit2.Response



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun loginsereen( navController: NavController) {
    val context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.wave),
            contentDescription = "Localized description",
            tint = bluecolour

        )


        Text(
            modifier = Modifier.padding(top = 80.dp), text = "Login",
            fontSize = 48.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Welcome back you’ve\n" + "     been missed!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp, color = Color.Gray
        )
        var text1 by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 53.dp)
                .fillMaxWidth(0.9f)
                .height(65.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = textfieldcolour,
                focusedLabelColor = textfieldcolour,
                focusedTextColor = black
            ),

            placeholder = { Text(text = "esmail@.com") },
            value = text1, onValueChange = { text1 = it },

            label = { Text(text = "Email", fontSize = 20.sp) },
            singleLine = true,


            )

        var text2 by remember {
            mutableStateOf("")
        }
        var visibilityPassword by rememberSaveable { mutableStateOf(value = false) }
        OutlinedTextField(value = text2, onValueChange = { text2 = it }, modifier = Modifier
            .padding(top = 31.dp)
            .fillMaxWidth(0.9f)
            .height(65.dp),

            visualTransformation = if (visibilityPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },

            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = textfieldcolour,
                focusedLabelColor = textfieldcolour,
                focusedTextColor = black
            ),
            label = { Text(text = "password", fontSize = 20.sp) },
            trailingIcon = {
                IconButton(onClick = { visibilityPassword = !visibilityPassword }) {

                    Icon(
                        painter = painterResource(R.drawable.passwordicon),
                        contentDescription = "", modifier = Modifier.size(29.dp)
                    )


                }
            })
        Text(
            text = "Reset password", modifier = Modifier.padding(top = 44.dp),
            fontSize = 20.sp, color = bluecolour
        )

        TextButton(
            onClick = {

                val email = text1
                val password = text2
                val loginRequest = LoginRequest(email, password)
                ApiManger.getapiservices().userregister(loginRequest)
                    .enqueue(object : retrofit2.Callback<LoginResponse> {
                        override fun onResponse(
                            p0: Call<LoginResponse>,
                            p1: Response<LoginResponse>
                        ) {
                            val body = p1.body()
                            if (p1.isSuccessful && body != null) {
                                saveToken(context,email)
                                when (body.message) {
                                    "success" -> {
                                        // Handle successful login
                                        Toast.makeText(
                                            context,
                                            "Login successful",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        Log.e(
                                            "tag",
                                            "onResponse: Login successful, token: ${body.token}"
                                        )
                                        saveToken(context, body.token)
                                        decodeAndSaveTokenData(context, body.token)
                                        if (getRole(context) == "admin") { navController.navigate(Screens.admin.route)}
                                        else if (getRole(context) == "user") {navController.navigate(Screens.employee.route)}
                                        /*  */
                                        Log.e("tag", "onResponse: Login  , token: ${body.token}")
                                        Log.e(
                                            "tag",
                                            "onResponse: Login  , token: ${getRole(context)}"
                                        )
                                        // Store the token for future use (e.g., using SharedPreferences)
                                        // Handle successful login logic (e.g., navigate to main screen)
                                    }

                                }


                            } else {
                                Toast.makeText(
                                    context,
                                    "incorrect email or password",
                                    Toast.LENGTH_LONG
                                ).show()

                            }

                        }


                        override fun onFailure(p0: Call<LoginResponse>, p1: Throwable) {
                            // Handle network error or failure
                            Log.e(
                                "tag",
                                "onFailure: Error occurred during login request",
                                p1
                            ) // Or display user-friendly error message
                        }
                    })


            }, modifier = Modifier
                .padding(top = 39.dp)
                .fillMaxWidth(0.9f)
                .height(65.dp)
                .clip(RoundedCornerShape(1.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
        ) {
            Text(text = "login", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = white)

        }

    }

}




/*)) {


   */










@Composable
@Preview
fun loginscreenpreview(){


}