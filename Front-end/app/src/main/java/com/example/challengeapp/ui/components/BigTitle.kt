package com.example.challengeapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun BigTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MainBlue,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

