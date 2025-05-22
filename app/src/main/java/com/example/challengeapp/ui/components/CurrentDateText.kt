package com.example.challengeapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CurrentDateText() {
    val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
        .format(Date())

    Text(
        text = currentDate,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}
