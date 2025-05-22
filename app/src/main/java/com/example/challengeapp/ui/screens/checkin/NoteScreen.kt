package com.example.challengeapp.ui.screens.checkin

import CheckInViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.ui.theme.MainBlue
import kotlin.math.min


@Composable
fun NoteScreen(
    navController: NavController,
    viewModel: CheckInViewModel
) {
    var note by remember { mutableStateOf(viewModel.noteText.value) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {

            Text(
                "Anote",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            Text(
                "Reserve um momento para anotar os motivos pelos quais você está se sentindo assim ou, se preferir, escreva algumas razões para ser grato pelo dia de hoje ou um acontecimento importante.",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = note,
                onValueChange = {
                    note = it
                    viewModel.setNote(it)
                },
                placeholder = { Text("Digite aqui...") },
                modifier = Modifier.fillMaxWidth().heightIn(min = 100.dp), shape = RoundedCornerShape(16.dp)
            )
        }

        Button(
            onClick = {
                viewModel.saveNote()
                navController.navigate("dashboard") {
                    popUpTo("note") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(MainBlue),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Salvar e voltar para o dashboard", color = Color.White)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NoteScreenPreview() {
    val navController = rememberNavController()
    NoteScreen(navController, viewModel())
}
