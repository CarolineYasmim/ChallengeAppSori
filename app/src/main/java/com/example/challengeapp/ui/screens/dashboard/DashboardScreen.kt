package com.example.challengeapp.ui.screens.dashboard

import CheckInViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.Model.Feeling
import com.example.challengeapp.ui.components.CurrentDateText
import com.example.challengeapp.ui.components.FeelingsCard
import com.example.challengeapp.ui.components.HumorCard
import com.example.challengeapp.ui.components.Logo
import com.example.challengeapp.ui.components.LogoWhite
import com.example.challengeapp.ui.components.MotivacionalPhraseCard
import com.example.challengeapp.ui.components.SamplePhrases
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun DashboardScreen(
    navController: NavController,
    onCardClick: () -> Unit,
    viewModel: CheckInViewModel // usar o mesmo ViewModel que a Note e CheckIn
) {
    val currentFeeling by viewModel.currentFeeling.collectAsState()
    val notes by viewModel.notes.collectAsState()


    val phrase = SamplePhrases()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .background(MainBlue)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 50.dp, bottom = 25.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LogoWhite()
                CurrentDateText()
            }
        }

        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            HumorCard(currentFeeling, onCardClick, Modifier.padding(vertical = 20.dp))

            MotivacionalPhraseCard()

            FeelingsCard(notes)

            Text("Sair", color = Color.Red, modifier = Modifier.clickable { navController.navigate("login") {
                popUpTo("dashboard") { inclusive = true }
            }})
            Spacer(Modifier.height(60.dp))
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DashboardScreenPreview() {

    val navController = rememberNavController()

    DashboardScreen(navController, {}, viewModel())

}

