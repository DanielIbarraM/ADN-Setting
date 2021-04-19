package com.example.infraestructura.anticorrupcion;

import java.util.Calendar;

public class FechaTraductor {

    public static Calendar mapearDeLongACalendar (long tiempo){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(tiempo);
        return calendar;
    }

    public static long mapeaDeCalendarALong (Calendar calendar) {
        if (calendar==null) return 0;
        return calendar.getTimeInMillis();
    }
}
