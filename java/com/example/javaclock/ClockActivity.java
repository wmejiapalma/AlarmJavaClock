package com.example.javaclock;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.example.Models.Clock;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockActivity extends AppCompatActivity {
    SetAlarms alarms = new SetAlarms();
    Clock clock = new Clock();
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
        whileOpen();
        clock.getHour();
    }

    private void whileOpen(){
        if (exec.isShutdown()){
            exec = Executors.newSingleThreadScheduledExecutor();
        }
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                startClockAndDate();
                checkForAlarms();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private void startClockAndDate(){
        final TextView clock = findViewById(R.id.clock);
        final TextView seconds = findViewById(R.id.seconds);
        final TextView date = findViewById(R.id.date);
        final TextView weekDay = findViewById(R.id.Weekday);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateClock(clock,seconds,date,weekDay);
            }
        });
    }

    private void updateClock(TextView clockText,TextView secondsText,TextView date, TextView weekDay){
            Clock clock = new Clock();
            clockText.setText(clock.getClockTime());
            secondsText.setText(clock.getSeconds());
            date.setText(clock.getDate());
            weekDay.setText(clock.getWeekDay());
    }

    public void setAlarmsButton(View v){
        exec.shutdown();
        setContentView(R.layout.set_alarms);
    }

    public void alarmSetter(View v){
        Spinner hourSpinner = findViewById(R.id.hourSpinner);
        Spinner minuteSpinner = findViewById(R.id.minuteSpinner);
        Switch amPM = findViewById(R.id.amPMSwitch);
        Spinner monthSpinner = findViewById(R.id.monthSpinner);
        Spinner daySpinner = findViewById(R.id.daySpinner);
        String hour = hourSpinner.getSelectedItem().toString();
        String minute = minuteSpinner.getSelectedItem().toString();
        String month = monthSpinner.getSelectedItem().toString();
        String day = daySpinner.getSelectedItem().toString();
        boolean amPMCheck = amPM.isChecked();
        alarms.alarmSetter(hour,minute,amPMCheck,month,day);
    }

    public void backToClockButton(View v){
        setContentView(R.layout.clock);
        whileOpen();
    }

    public void playAlarm(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.alarmsound);
        mediaPlayer.start();
    }

    public void checkForAlarms(){
        String hour = clock.getHour();
        int hourInt = Integer.parseInt(hour);
        String amOrPM = "am";
        if(hourInt > 12){
            amOrPM = "pm";
            hourInt = hourInt - 12;
            hour = String.valueOf(hourInt);
        }
        System.out.println(hour + clock.getMinute() + amOrPM + clock.getMonth() + clock.getDay());
        alarms.checkForAlarms(hour,clock.getMinute(),amOrPM,clock.getMonth(),clock.getDay());
    }

}