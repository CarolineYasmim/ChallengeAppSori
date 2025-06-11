package com.example.challengeapp.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.ui.components.BigTitle
import com.example.challengeapp.ui.components.FormTextfield
import com.example.challengeapp.ui.components.Logo
import com.example.challengeapp.ui.components.RoundedButton
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun LoginScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var errorName by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var errorEmail by remember {mutableStateOf(false)}

    var password by remember { mutableStateOf("") }
    var errorPassword by remember { mutableStateOf(false) }

    var confirmPassword by remember { mutableStateOf("") }
    var errorConfirmPassword by remember { mutableStateOf(false) }
    var showPasswordMismatchError by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(vertical = 60.dp, horizontal = 40.dp).verticalScroll(
            rememberScrollState()
        ),

        ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Logo()
            BigTitle(modifier = Modifier.padding(top = 40.dp),"Entre na sua conta")
            Text(
                "Digite seus dados para fazer login",
                color = MainBlue,
                modifier = Modifier.padding(bottom = 40.dp, top = 10.dp)
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {


            /////////////////////////////////////////////////////////////////////

            Column {
                FormTextfield(
                    modifier = Modifier.fillMaxWidth(),
                    inputValue = email,
                    onValueChange = {
                        email = it
                        if (errorEmail && it.isNotBlank()) {
                            errorEmail = false // Remove o erro ao digitar algo
                        } },
                    placeholderText = "E-mail",
                    keyboardtype = KeyboardType.Email,
                    isError = errorEmail
                )

                if (errorEmail) {
                    Text("O Campo de email não pode estar vazio", color = Color.Red, fontSize = 12.sp)
                }
            }

            /////////////////////////////////////////////////////////////////////


            Column {
                FormTextfield(
                    modifier = Modifier.fillMaxWidth(),
                    inputValue = password,
                    onValueChange = {
                        password = it
                        if (errorPassword && it.isNotBlank()) {
                            errorPassword = false // Remove o erro ao digitar algo
                        }
                    },
                    placeholderText = "Senha",
                    keyboardtype = KeyboardType.Password,
                    isError = errorPassword
                )

                if (errorPassword) {
                    Text("O Campo de email não pode estar vazio", color = Color.Red, fontSize = 12.sp)
                }
            }

            /////////////////////////////////////////////////////////////////////

        }

        Spacer(Modifier.height(28.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(60.dp)) {
            RoundedButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Entrar",
            ) {
                var hasError = false

                if (email.isBlank()) {
                    errorEmail = true
                    hasError = true
                }

                if (password.isBlank()) {
                    errorPassword = true
                    hasError = true
                }

                // Se não houver erro, navega ou executa a ação de cadastro
                if (!hasError) {
                    navController.navigate("dashboard") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            Text(
                text = "Não possui uma conta?\nClique aqui para criar uma",
                color = MainBlue,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    navController.navigate("signUp") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginPreview() {
    val navController = rememberNavController() // ou TestNavHostController(LocalContext.current)

    LoginScreen(navController)
}