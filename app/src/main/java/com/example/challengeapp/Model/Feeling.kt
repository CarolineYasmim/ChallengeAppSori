package com.example.challengeapp.Model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.challengeapp.R

enum class Feeling(
    val description: String,
    @DrawableRes val imagemResId: Int,
    val tip: String,
    val color: Color
) {
    MOTIVADO("Motivado", R.drawable.motivado, "Continue com esse foco!", Color(0xFF4CAF50)),
    ANIMADO("Animado", R.drawable.animado, "Compartilhe essa energia!", Color(0xFF03A9F4)),
    SATISFEITO("Satisfeito", R.drawable.satisfeito, "Curta esse momento!", Color(0xFF9C27B0)),

    TRISTE("Triste", R.drawable.triste, "Fale com alguém de confiança.", Color(0xFF2196F3)),
    MEDO("Medo", R.drawable.medo, "Respire fundo e se proteja.", Color(0xFF673AB7)),
    CANSADO("Cansado", R.drawable.cansado, "Tire um tempo para descansar.", Color(0xFF607D8B)),
    ANSIOSO("Ansioso", R.drawable.ansioso, "Tente focar no presente.", Color(0xFFFFC107)),

    PREOCUPADO("Preocupado", R.drawable.preocupado, "Organize seus pensamentos.", Color(0xFFFF5722)),
    ESTRESSADO("Estressado", R.drawable.estressado, "Faça uma pausa e relaxe.", Color(0xFFFF9800)),
    RAIVA("Raiva", R.drawable.raiva, "Tente se acalmar com respirações profundas.", Color(0xFFF44336)),

    NEUTRO("Neutro", R.drawable.neutro, "Faça seu check-in diário", Color.LightGray)
}
