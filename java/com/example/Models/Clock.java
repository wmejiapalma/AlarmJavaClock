package com.example.Models;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class Clock{
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private SimpleDateFormat dayOfWeek = new SimpleDateFormat("EEEE");
    private SimpleDateFormat seconds = new SimpleDateFormat("ss");
    private Date systemTime = new Date();

    public String getClockTime(){
        return timeFormat.format(systemTime);
    }
    public String getDate(){
        return dateFormat.format(systemTime);
    }
    public String getWeekDay(){
        return dayOfWeek.format(systemTime);
    }
    public String getSeconds(){
        return seconds.format(systemTime);
    }
    public String getHour(){
        int hour = systemTime.toInstant().atZone(ZoneId.systemDefault()).getHour();
        return String.valueOf(hour);
    }
    public String getMinute(){
        int minute = systemTime.toInstant().atZone(ZoneId.systemDefault()).getMinute();
        return String.valueOf(minute);
    }
    public String getMonth(){
        Month month = systemTime.toInstant().atZone(ZoneId.systemDefault()).getMonth();
        return String.valueOf(month);
    }
    public String getDay(){
        int day = systemTime.toInstant().atZone(ZoneId.systemDefault()).getDayOfMonth();
        return String.valueOf(day);
    }

}