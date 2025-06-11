package com.example.challengeapp.ui.screens.checkin

import CheckInViewModel
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.Model.Feeling
import com.example.challengeapp.R
import com.example.challengeapp.ui.theme.LightBlue
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun CheckInScreen(
    navController: NavController,
    viewModel: CheckInViewModel
) {
    var selectedFeeling by remember { mutableStateOf<Feeling?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Como está se sentindo?",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(30.dp))

        val feelings = listOf(
            Feeling.MOTIVADO, Feeling.ANIMADO, Feeling.SATISFEITO,
            Feeling.TRISTE, Feeling.MEDO, Feeling.CANSADO, Feeling.ANSIOSO,
            Feeling.PREOCUPADO, Feeling.ESTRESSADO, Feeling.RAIVA
        )

        // Grid de ícones 3 colunas
        Column {
            feelings.chunked(3).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    row.forEach { feeling ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable { selectedFeeling = feeling }
                        ) {
                            Surface(
                                modifier = Modifier.size(64.dp),
                                shape = CircleShape,
                                color = if (selectedFeeling == feeling) feeling.color.copy(alpha = 0.3f) else Color.Transparent,
                                border = BorderStroke(
                                    2.dp,
                                    if (selectedFeeling == feeling) feeling.color else Color.LightGray
                                )
                            ) {
                                // Ícone fictício — troque pelo seu recurso se tiver
                                Icon(
                                    painter = painterResource(id = feeling.imagemResId), // troque pelo real
                                    contentDescription = feeling.description,
                                    tint = if (selectedFeeling == feeling) feeling.color else Color.LightGray,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = feeling.description, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                selectedFeeling?.let {
                    viewModel.setFeeling(it)
                    navController.navigate("note") {
                        popUpTo("checkIn") { inclusive = true }
                    }
                }
            },
            enabled = selectedFeeling != null,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MainBlue,
                disabledContainerColor = LightBlue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Próximo", color = Color.White)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CheckInScreenPreview() {

    val navController = rememberNavController()

    CheckInScreen(
        navController,
        viewModel(),
    )
}