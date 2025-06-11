package com.example.challengeapp.ui.components

import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.challengeapp.R
import com.example.challengeapp.ui.theme.LogoGreen

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Icon(painter = painterResource(R.drawable.logo_sori), contentDescription = "Sori Logo", tint = LogoGreen, modifier = Modifier.height(80.dp))

    }
}