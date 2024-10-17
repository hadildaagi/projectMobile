package com.example.application_mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register() {
    // Créer des états pour chaque champ de texte
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val userName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.sign_in),
            contentDescription = "Login Image",
            modifier = Modifier.size(220.dp)
        )

        Text(text = "Welcome Back !!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Please enter your details:")
        Spacer(modifier = Modifier.height(20.dp))

        // Champ pour le nom complet
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = firstName.value,
                onValueChange = { firstName.value = it }, // Met à jour la valeur
                label = { Text(text = "First Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF51D3F),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color(0xFFF51D3F),
                    focusedLabelColor = Color(0xFFF51D3F)
                ),
                modifier = Modifier.weight(1f).padding(end = 4.dp) // Ajoute un espacement à droite
            )
            OutlinedTextField(
                value = lastName.value,
                onValueChange = { lastName.value = it }, // Met à jour la valeur
                label = { Text(text = "Last Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF51D3F),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color(0xFFF51D3F),
                    focusedLabelColor = Color(0xFFF51D3F)
                ),
                modifier = Modifier.weight(1f).padding(start = 4.dp) // Ajoute un espacement à gauche
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userName.value,
            onValueChange = { userName.value = it }, // Met à jour la valeur
            label = { Text(text = "User Name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF51D3F),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFFF51D3F),
                focusedLabelColor = Color(0xFFF51D3F)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it }, // Met à jour la valeur
            label = { Text(text = "Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF51D3F),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFFF51D3F),
                focusedLabelColor = Color(0xFFF51D3F)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it }, // Met à jour la valeur
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF51D3F),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFFF51D3F),
                focusedLabelColor = Color(0xFFF51D3F)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it }, // Met à jour la valeur
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF51D3F),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFFF51D3F),
                focusedLabelColor = Color(0xFFF51D3F)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                    val intent = Intent(context,Sign_C::class.java)
                    context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF51D3F),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth() // Remplir la largeur
        ) {
            Text(text = "Sign In")}
        Spacer(modifier = Modifier.height(16.dp))
    }
}

class Register_C : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Register()
        }
    }
}