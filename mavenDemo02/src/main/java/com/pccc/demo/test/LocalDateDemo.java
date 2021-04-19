package com.pccc.demo.test;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

/**
 * @Author jinquanhua
 * @date 2021/3/15 14:32
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        WeekFields iso = WeekFields.ISO;
        System.out.println(now.get(iso.weekOfWeekBasedYear()));
        System.out.println(now.get(iso.weekBasedYear()));

    }
}
