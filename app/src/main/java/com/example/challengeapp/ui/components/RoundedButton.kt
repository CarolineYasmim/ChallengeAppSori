package com.example.challengeapp.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun RoundedButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 160.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            MainBlue
        )
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.Bold)
    }
}


@Preview
@Composable
private fun RoundedButtonPreview() {
    RoundedButton(Modifier,"Começar", {})
}