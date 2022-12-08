package com.example.composecalendar.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.composecalendar.utils.Const
import com.example.composecalendar.utils.Tools
import java.util.*


class CalendarWidget : GlanceAppWidget() {
    @Composable
    fun CalendarWeek(
        daysOfWeek: List<String> = Const.DAYS_OF_WEEKS
    ) {
        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally
        ) {
            daysOfWeek.forEach { calWeek ->
                Text(
                    text = calWeek,
                    modifier = GlanceModifier.wrapContentSize().padding(horizontal = 10.dp),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = ColorProvider(Color.Black),
                    )
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
                    modifier = GlanceModifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Horizontal.CenterHorizontally
                ) {
                    for (i in 0 until Const.DAYS_OF_WEEKS.size) {
                        if (shouldWait) {
                            Box(
                                modifier = GlanceModifier
                                    .wrapContentSize()
                                    .padding(horizontal = 20.dp)
                            ) {}
                            if (Const.DAYS_OF_WEEKS[i] == Tools.getDateRange().first.first()) {
                                shouldWait = false
                            }
                        }
                        if (!shouldWait && count <= daysOfWeek) {
                            Box(
                                modifier = GlanceModifier
                                    .wrapContentSize()
                                    .background(color = if (dayNumber == count) Color.LightGray else Color.Transparent)
                                    .padding(horizontal = 15.dp)
                            ) {
                                Text(
                                    text = if (count < 10) "0$count" else count.toString(),
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        color = ColorProvider(Color.Black),
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
    override fun Content() {
        Column {
            CalendarWeek()
            CalendarDays()
        }
    }

}

class CalendarWidgetReceiver :
    GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = CalendarWidget()
}
