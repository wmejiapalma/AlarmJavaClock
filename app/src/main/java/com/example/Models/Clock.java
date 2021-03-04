package com.example.Models;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.javaclock.R;

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
        System.out.println(seconds.format(systemTime));
        return seconds.format(systemTime);
    }

}