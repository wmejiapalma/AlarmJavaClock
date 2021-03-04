package com.example.javaclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.Models.Clock;

public class ClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
        Button button = findViewById(R.id.button);
        whileOpen();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    private void openSettings(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void whileOpen(){
        startClockAndDate();
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

}