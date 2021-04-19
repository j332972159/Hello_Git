package com.pccc.demo.test;

import java.util.Calendar;

/**
 * @Author jinquanhua
 * @date 2021/3/15 14:01
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
    }
}
