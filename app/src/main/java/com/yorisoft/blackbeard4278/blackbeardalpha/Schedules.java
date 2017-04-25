package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.util.Log;

import java.util.Calendar;

public class Schedules {

    private int cDay;
    private int cMonth;
    private int cYear;
    private int sDay;
    private int sMonth;
    private int sYear;
    private int resDay;
    private int resMonth;
    private int resYear;
    private int resWeek;
    private int futureDate;

    public String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        cYear = c.get(Calendar.YEAR);
        cMonth = c.get(Calendar.MONTH);
        cMonth++;
        cDay = c.get(Calendar.DAY_OF_MONTH);
        return cDay + ":" + cMonth + ":" + cYear;
    }
    public void setCurrentDate() {
        Log.i("calculatebath",sMonth + "/" + sDay+ "/"+sYear);
        Calendar c = Calendar.getInstance();
        cYear = c.get(Calendar.YEAR);
        cMonth = c.get(Calendar.MONTH);
        cMonth++;
        cDay = c.get(Calendar.DAY_OF_MONTH);
    }

    public void setSelectedDate(int nYear, int nMonth, int nDay) {
        sDay = nYear;
        sMonth = nMonth;
        sMonth++;
        sDay = nDay;

    }
    public void calculateDay() {

        if (cDay >= sDay) {
            resDay = cDay - sDay;
        } else {
            resDay = cDay - sDay;
            resDay = 30 + resDay;

        }
    }
    public void calculateWeek() {
        resWeek = resDay / 7;
    }
    public void calculateMonth() {
        if (cMonth >= sMonth) {
            resMonth = cMonth - sMonth;
        } else {
            resMonth = cMonth - sMonth;
            resMonth = 12 + resMonth;
            resYear--;
        }

    }

    public String getResult() {

        if(resMonth<=0 && resWeek<=0){
            return  resDay +" "+ "days";
        }
        if(resMonth<=0) {
            if(resDay >= 7){
                return (resDay-(resWeek*7)) +" "+ "days"+resWeek+"weeks";
            }
            return resWeek+"weeks";
        }
        if (resWeek>0 && resDay<=0){
            return resWeek + " " + "weeks";
        }
        else {
            return (resDay-(resWeek*7))+"days"+" "+resWeek+"weeks"+" "+resMonth+"months";
        }
    }

    public String getFutureDate () {
        int i = sDay + 7;

        int futureDate = i - cDay;

        return futureDate +"days";
    }

}
