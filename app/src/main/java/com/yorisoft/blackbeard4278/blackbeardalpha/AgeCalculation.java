package com.yorisoft.blackbeard4278.blackbeardalpha;



import java.util.Calendar;

public class AgeCalculation {
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private int endYear;
    private int endMonth;
    private int endDay;
    private int resWeek;


    public String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentMonth++;
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        return currentDay + ":" + currentMonth + ":" + currentYear;
    }

    public void setDateOfBirth(int bYear, int bMonth, int bDay) {
        birthYear = bYear;
        birthMonth = bMonth;
        birthMonth++;
        birthDay = bDay;

    }

    public void calculateYear() {
        endYear = currentYear - birthYear;

    }

    public void calculateMonth() {
        if (currentMonth >= birthMonth) {
            endMonth = currentMonth - birthMonth;
        } else {
            endMonth = currentMonth - birthMonth;
            endMonth = 12 + endMonth;
            endYear--;
        }

    }

    public void calculateDay() {

        if (currentDay >= birthDay) {
            endDay = currentDay - birthDay;
        } else {
            endDay = currentDay - birthDay;
            endDay = 30 + endDay;

        }
    }
    public void calculateWeek() {
        resWeek = endDay / 7;
    }

    public String getResult() {
        if(endYear <=0 && endMonth > 0) {
            if(resWeek<=0) {
                return endMonth + "Months";
            }
            return endMonth + "Months" + " " +  " " + resWeek + "Weeks";
        }
        if (endYear <= 0 && endMonth <=0 && resWeek <=0 ) {
            return  endDay + "Days";
        }
        if(endYear <=0 && endMonth <= 0 && resWeek > 0) {
            return resWeek + "Weeks" + " " + " " + (endDay-(resWeek*7)) + "Days" ;
        }
        if (endYear > 0) {
            return endYear + " " + "Years"+ " " + " " + endMonth + " " + "Months";
        }
        else {
            return endDay + "d" + " " + endMonth + "m" + " " + endYear + "y";
        }
    }
}




