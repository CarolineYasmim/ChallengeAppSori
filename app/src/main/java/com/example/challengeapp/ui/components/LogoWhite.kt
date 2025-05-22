package com.example.challengeapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // ✅ este é o correto
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.challengeapp.R

@Composable
fun LogoWhite(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.logo_sori),
            contentDescription = "Sori Logo",
            tint = Color.White, // Agora vai funcionar corretamente
            modifier = Modifier.height(60.dp)
        )
    }
}
