package com.example.composecalendar.model

import android.content.Context
import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.composecalendar.R
import com.example.composecalendar.utils.Const


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
                Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                style = MStyle.customTextStyle()
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
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { CalendarView(ContextThemeWrapper(it,R.style.calendar_style)) },
            update = {

            }
        )
    }
}

@Composable
fun CalendarWeek(
    daysOfWeek: List<String> = Const.DAYS_OF_WEEKS
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        daysOfWeek.forEach { calWeek ->
            Text(
                text = calWeek,
                style = MStyle.customTextStyle(color = Color.Black)
            )
        }
    }
}
