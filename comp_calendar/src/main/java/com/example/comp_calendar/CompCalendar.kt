package com.example.comp_calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.comp_calendar.utils.CompCalendar
import java.util.*

@Composable
fun CalendarWeek(
    textStyle: TextStyle
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CompCalendar.DAYS_OF_WEEKS.forEach { calWeek ->
            Text(
                text = calWeek,
                style = textStyle
            )
        }
    }
}

@Composable
fun CalendarDays(
    textStyle: TextStyle
) {
    Column {
        val calendar = Calendar.getInstance()
        val dateRange = CompCalendar.getDateRange()
        val daysOfWeek = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayNumber = calendar.get(Calendar.DATE)
        var count = 1
        var shouldWait = true
        while (count <= daysOfWeek) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in 0 until CompCalendar.DAYS_OF_WEEKS.size) {
                    if (shouldWait) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = 20.dp)
                        )
                        if (CompCalendar.DAYS_OF_WEEKS[i] == dateRange.first.first()) {
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
                                style = textStyle
                            )
                        }
                        count++
                    }
                }
            }
        }
    }
}