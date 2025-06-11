package com.example.challengeapp.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.R
import com.example.challengeapp.ui.components.OnboardingPagination
import com.example.challengeapp.ui.components.RoundedButton
import com.example.challengeapp.ui.theme.LightBlue
import com.example.challengeapp.ui.theme.LogoGreen
import com.example.challengeapp.ui.theme.MainBlue
import com.example.challengeapp.ui.theme.TextBlue
import java.nio.file.WatchEvent

@Composable
fun HelloScreen1(navController: NavController) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color.White).verticalScroll(rememberScrollState()).padding(bottom = 60.dp)
    ) {

        Box(
            modifier = Modifier
                .height(357.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.woman_smiley),
                contentDescription = "Woman Smiley",
                contentScale = ContentScale.Crop, // ou .FillBounds dependendo do efeito desejado
                modifier = Modifier.fillMaxSize() // faz a imagem ocupar toda a Box
            )
        }


        Text(
            "Olá!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MainBlue,
            modifier = Modifier.padding(top = 32.dp)
        )

        Text(
                    " Aqui você encontra um espaço seguro e acolhedor para acompanhar como se sente, reconhecer sinais de estresse e receber apoio constante. \n" +
                    "\n" +
                    "Queremos ajudar você a se sentir mais forte a cada dia e lembrar que sua saúde emocional importa.",
            textAlign = TextAlign.Center,
            color = TextBlue,
            modifier = Modifier.padding(vertical = 28.dp, horizontal = 34.dp)
        )
        OnboardingPagination(MainBlue, LightBlue, LightBlue)
        RoundedButton(Modifier.padding(top = 16.dp, bottom = 24.dp),"Começar") {
            navController.navigate("hello2") {
                popUpTo("hello1") { inclusive = true }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HelloScreen1Preview() {
    val navController = rememberNavController() // ou TestNavHostController(LocalContext.current)

    HelloScreen1(navController)
}