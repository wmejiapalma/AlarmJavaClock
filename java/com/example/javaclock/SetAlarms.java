package com.example.javaclock;

import java.util.ArrayList;

public class SetAlarms {
    private ArrayList<String> alarmsArray = new ArrayList<String>();
    public void alarmSetter(String hourParam, String minuteParam, boolean amOrPMParam, String monthParam, String dayParam){
        // amOrPMParam false = AM true = PM
        String amOrPM = "am";
        if(amOrPMParam){
            amOrPM = "pm";
        }
        if(!alarmsArray.contains(hourParam + minuteParam + amOrPM + monthParam + dayParam)){
            alarmsArray.add(hourParam + minuteParam + amOrPM + monthParam + dayParam);
        }
    }

    public void checkForAlarms(String hourParam, String minuteParam, String amOrPMParam, String monthParam, String dayParam){
        if(alarmsArray.contains(hourParam + minuteParam + amOrPMParam + monthParam + dayParam)){
            new ClockActivity().playAlarm();
            System.out.println("CHECK3");
            alarmsArray.remove(hourParam + minuteParam + amOrPMParam + monthParam + dayParam);
        }
    }

}
