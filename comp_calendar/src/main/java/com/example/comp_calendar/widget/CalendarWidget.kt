package com.example.comp_calendar.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.comp_calendar.utils.CompCalendar
import java.util.*

@Composable
fun CompCalendarWidgetWeek(
    daysOfWeek: List<String> = CompCalendar.DAYS_OF_WEEKS
) {
    Row(
        modifier = GlanceModifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Horizontal.CenterHorizontally
    ) {
        daysOfWeek.forEach { calWeek ->
            Text(
                text = calWeek,
                modifier = GlanceModifier.wrapContentSize().padding(horizontal = 5.dp),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = ColorProvider(Color.Yellow),
                )
            )
        }
    }
}

@Composable
fun CompCalendarWidgetDays() {
    Column {
        val calendar = Calendar.getInstance()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayNumber = calendar.get(Calendar.DATE)
        var count = 1
        var shouldWait = true
        while (count <= daysInMonth) {
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally
            ) {
                for (i in 0 until CompCalendar.DAYS_OF_WEEKS.size) {
                    if (shouldWait) {
                        Box(
                            modifier = GlanceModifier
                                .wrapContentSize()
                                .padding(horizontal = 15.dp)
                        ) {}
                        if (CompCalendar.DAYS_OF_WEEKS[i] == CompCalendar.getDateRange().first.first()) {
                            shouldWait = false
                        }
                    }
                    if (!shouldWait && count <= daysInMonth) {
                        Box(
                            modifier = GlanceModifier
                                .wrapContentSize()
                                .background(color = if (dayNumber == count) Color.LightGray else Color.Transparent)
                                .padding(horizontal = 10.dp)
                        ) {
                            Text(
                                text = if (count < 10) "0$count" else count.toString(),
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    color = ColorProvider(Color.Yellow),
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


@Composable
fun CompCalendarWidgetMonth() {
    val calendar = Calendar.getInstance()
    val monthName: String =
        calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) as String
    Text(
        modifier = GlanceModifier.fillMaxWidth(),
        text = monthName,
        style = TextStyle(
            color = ColorProvider(Color.White),
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
    )
}
