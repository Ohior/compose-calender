package com.example.composecalendar.model

import android.widget.CalendarView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object MStyle {
    fun customTextStyle(
        fontSize: TextUnit = 20.sp,
        fontFamily: FontFamily = FontFamily.SansSerif,
        fontWeight: FontWeight = FontWeight.SemiBold,
        textAlign: TextAlign = TextAlign.Center,
        color: Color = Color.Cyan
    ): TextStyle {
        return TextStyle(
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            textAlign = textAlign,
            color = color
        )
    }

    @Composable
    fun SurfaceLayer(
        modifier:Modifier = Modifier,
        border:BorderStroke = BorderStroke(2.dp, Color.Black),
        color: Color = Color.Transparent,
        elevation:Dp = 3.dp,
        content:@Composable ()-> Unit
    ) {
        Surface(
            modifier = modifier,
            border = border,
            elevation = elevation,
            color = color
        ) {
            content()
        }
    }
}