package com.example.composecalendar.model

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composecalendar.R
import com.example.composecalendar.utils.Const
import com.example.composecalendar.utils.Tools
import java.util.Calendar


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
        CalendarWeek()
        MStyle.SurfaceLayer {
            CalendarDays()
        }
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

@Composable
fun CalendarDays() {
    Column {
        val calendar = Calendar.getInstance()
        val daysOfWeek = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayNumber = calendar.get(Calendar.DATE)
        var count = 1
        var shouldWait = true
        while (count <= daysOfWeek) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in 0 until Const.DAYS_OF_WEEKS.size) {
                    if (shouldWait) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = 20.dp)
                        )
                        if (Const.DAYS_OF_WEEKS[i] == Tools.getDateRange().first.first()) {
                            shouldWait = false
                        }
                    }
                    if (!shouldWait && count <= daysOfWeek) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = if (dayNumber == count) Color.LightGray else MaterialTheme.colors.background)
                                .padding(horizontal = 15.dp)
                        ) {
                            Text(
                                text = if (count < 10) "0$count" else count.toString(),
                                style = MStyle.customTextStyle(
                                    color = Color.Black,
                                )
                            )
                        }
                        count++
                    }
                }
            }
        }
    }
}
