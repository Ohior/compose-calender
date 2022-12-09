package com.example.composecalendar.model

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.example.comp_calendar.CalendarDays
import com.example.comp_calendar.CalendarWeek
import com.example.composecalendar.R


@Composable
fun AppWindow(
    context: Context,
    lambda: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        topBar = {
            Text(
                text = context.getString(R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                style = customTextStyle()
            )
        }
    ) { paddingValues ->
        lambda(paddingValues)
    }
}


@Composable
fun AppBody(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CalendarWeek(textStyle = customTextStyle(color = Color.Black))
        SurfaceLayer {
            CalendarDays(textStyle = customTextStyle(color = Color.Black))
        }
    }
}


@Composable
fun SurfaceLayer(
    modifier:Modifier = Modifier,
    border: BorderStroke = BorderStroke(1.dp, Color.Black),
    color: Color = Color.Transparent,
    elevation: Dp = 1.dp,
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

fun customTextStyle(
    fontSize: TextUnit = 20.sp,
    fontFamily: FontFamily = FontFamily.SansSerif,
    fontWeight: FontWeight = FontWeight.SemiBold,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Color.Red,
    background: Color = Color.Transparent,
): TextStyle {
    return TextStyle(
        fontSize = fontSize,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        textAlign = textAlign,
        color = color,
        background = background
    )
}