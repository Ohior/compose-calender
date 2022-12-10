package com.example.composecalendar.widget

import androidx.compose.runtime.Composable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.layout.Column
import com.example.comp_calendar.widget.CompCalendarWidgetDays
import com.example.comp_calendar.widget.CompCalendarWidgetMonth
import com.example.comp_calendar.widget.CompCalendarWidgetWeek

class CalendarWidget : GlanceAppWidget() {
    @Composable
    override fun Content() {
        Column {
            CompCalendarWidgetMonth()
            CompCalendarWidgetWeek()
            CompCalendarWidgetDays()
        }
    }
}

class CalendarWidgetReceiver :
    GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = CalendarWidget()
}