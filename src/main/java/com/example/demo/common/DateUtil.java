package com.example.demo.common;

import org.joda.time.DateTimeZone;

import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    private static TimeZone _tz = TimeZone.getTimeZone("UTC");
    public static Date convertToUTC(Date date) {
        DateTimeZone d = DateTimeZone.getDefault();
        return new Date(d.convertLocalToUTC(date.getTime(), false));
    }
}
