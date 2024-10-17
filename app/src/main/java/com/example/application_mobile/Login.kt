package com.example.application_mobile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun Login() {
    val context = LocalContext.current

    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    // État pour gérer l'affichage de l'alerte
    var showAlert by remember { mutableStateOf(false) }
    var alertMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = "Login Image",
            modifier = Modifier.size(220.dp)
        )

        Text(text = "Welcome Back !!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Please enter your user name and password !!")
        Spacer(modifier = Modifier.height(20.dp))

        // Champ pour le nom d'utilisateur
        OutlinedTextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            label = { Text(text = "User name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Blue,
                focusedLabelColor = Color.Blue
            ),
            shape = RoundedCornerShape(8.dp) // Ajout d'un coin arrondi
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Champ pour le mot de passe
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Blue,
                focusedLabelColor = Color.Blue
            ),
            shape = RoundedCornerShape(8.dp) // Ajout d'un coin arrondi
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (userName.value == "hadil20" && password.value == "123456") {
                    val intent = Intent(context, Login_C::class.java)
                    context.startActivity(intent)
                } else {
                    // Affiche une alerte si le nom d'utilisateur ou le mot de passe est incorrect
                    showAlert = true
                    alertMessage = "Nom d'utilisateur ou mot de passe incorrect"
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp) // Ajout d'un coin arrondi
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Forget Password?",
            modifier = Modifier.clickable {

                val intent = Intent(context, forget_pass::class.java)
                context.startActivity(intent)
            },
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Button to navigate to Register screen
        Button(
            onClick = {
                val intent = Intent(context, Register_C::class.java) // Assurez-vous que Register est importé
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Or Sign in with")

            Spacer(modifier = Modifier.width(8.dp))

            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Facebook Login
            Image(
                painter = painterResource(id = R.drawable.fcb),
                contentDescription = "Facebook Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/login"))
                        context.startActivity(intent)
                    }
            )
            // Apple Login
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Apple Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://appleid.apple.com/auth"))
                        context.startActivity(intent)
                    }
            )
            // Google Login
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signin"))
                        context.startActivity(intent)
                    }
            )
        }
    }

    // Alerte pour afficher le message d'erreur
    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = { Text("Erreur") },
            text = { Text(alertMessage) },
            confirmButton = {
                Button(onClick = { showAlert = false }) {
                    Text("OK")
                }
            }
        )
    }
}
