package com.the.coso.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp
import com.the.coso.R


val Lato = FontFamily(
    Font(R.font.lato_black,FontWeight.Black),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_light,FontWeight.Light),
    Font(R.font.lato_regular,FontWeight.Normal)

)


// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Lato
    ),
    displayMedium = TextStyle(
        fontFamily = Lato
    ),
    displaySmall = TextStyle(
        fontFamily = Lato
    ),
    headlineLarge = TextStyle(
        fontFamily = Lato
    ),
    headlineMedium = TextStyle(
        fontFamily = Lato
    ),
    headlineSmall = TextStyle(
        fontFamily = Lato
    ),
    titleLarge = TextStyle(
        fontFamily = Lato
    ),
    titleMedium = TextStyle(
        fontFamily = Lato
    ),
    titleSmall = TextStyle(
        fontFamily = Lato
    ),
    bodyLarge = TextStyle(
        fontFamily = Lato
    ),
    bodyMedium = TextStyle(
        fontFamily = Lato
    ),
    bodySmall = TextStyle(
        fontFamily = Lato
    ),
    labelLarge = TextStyle(
        fontFamily = Lato
    ),
    labelMedium = TextStyle(
        fontFamily = Lato
    ),
    labelSmall = TextStyle(
        fontFamily = Lato
    ),
)