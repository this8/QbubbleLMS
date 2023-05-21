package com.nsbm.qbubble

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsbm.qbubble.ui.theme.QbubbleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    //https://developer.android.com/jetpack/compose/state
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Logo
        //ToDo: Change Qbubble Logo
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Qbubble Logo")
        //email textField
        OutlinedTextField(
            value = email,
            //https://developer.android.com/codelabs/basic-android-kotlin-compose-using-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-using-state#4
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        //password textField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            //password as star characters
            visualTransformation = PasswordVisualTransformation('\u2022')
        )
        //login button
        Button(
            onClick = {
                // Perform login logic here
                      loginUser(email, password)
            }, modifier = Modifier.fillMaxWidth(), shape = ShapeDefaults.ExtraSmall,
            enabled = (email.isNotEmpty() && password.isNotEmpty())
        ) {
            Text(text = "Login", fontSize = 16.sp)
        }
    }
}

fun loginUser(email: String, password: String) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    QbubbleTheme {
        LoginScreen()
    }
}