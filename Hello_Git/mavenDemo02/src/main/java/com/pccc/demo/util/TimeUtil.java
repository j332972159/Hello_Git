package com.pccc.demo.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author jinquanhua
 * @date 2020/12/25 16:23
 */
public class TimeUtil {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
}
