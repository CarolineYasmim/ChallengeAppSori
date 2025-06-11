package com.example.challengeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengeapp.ui.theme.LightBlue
import com.example.challengeapp.ui.theme.MainBlue

@Composable
fun OnboardingPagination( color1: Color, color2: Color, color3: Color) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .height(3.dp)
            .width(20.dp)
            .background(color1)
        )
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .height(3.dp)
            .width(20.dp)
            .background(color2)
        )
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .height(3.dp)
            .width(20.dp)
            .background(color3)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingPaginationPreview() {
    OnboardingPagination(MainBlue, LightBlue, LightBlue)
}