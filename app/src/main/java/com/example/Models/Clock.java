package com.example.Models;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;

import com.example.javaclock.R;

public class Clock extends AppCompatActivity {


    public void start(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
    }
    private void updateClock(){

    }
    public void newFunction(){

    }
    private String getSystemTime(){
        Date currentTime = Calendar.getInstance().getTime();
        return currentTime.toString();
    }
}