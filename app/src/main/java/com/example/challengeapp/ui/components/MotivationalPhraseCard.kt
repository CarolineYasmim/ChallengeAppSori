package com.example.challengeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengeapp.R
import com.example.challengeapp.ui.theme.MainBlue
import com.seuprojeto.motivacional.SamplePhrases

@Composable
fun MotivacionalPhraseCard(textComponent: String? = null) {

    val samplePhrases = SamplePhrases()
    val randomPhrase = samplePhrases.phrases.random()

    Column(Modifier.fillMaxWidth()) {
        Text("Motivação Diária", color = Color.Black, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(6.dp))
        Box(Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(MainBlue)
            .height(226.dp)
            .fillMaxWidth()
            )
         {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(26.dp)
            ) {
                Text("' ${randomPhrase} '", color = Color.White, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MotivacionalPhraseCardPreview() {
    MotivacionalPhraseCard()
}