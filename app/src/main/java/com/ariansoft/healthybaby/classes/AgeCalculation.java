package com.ariansoft.healthybaby.classes;

import java.util.Calendar;

public class AgeCalculation {
    private int age;
    private int resYear;
    private int resMonth;
    private int resDay;
    public AgeCalculation(int DOByear, int DOBmonth, int DOBday) {

        int age;

        final Calendar calenderToday = Calendar.getInstance();
        int currentYear = calenderToday.get(Calendar.YEAR);
        int currentMonth = 1 + calenderToday.get(Calendar.MONTH);
        int todayDay = calenderToday.get(Calendar.DAY_OF_MONTH);

        age = currentYear - DOByear;

        if(DOBmonth > currentMonth){
            --age;
        }
        else if(DOBmonth == currentMonth){
            if(DOBday > todayDay){
                --age;
            }
        }
        this.age=age;
        calcualte();
    }

    public void calcualte() {
        resYear = age / (365);
        resMonth=(age-(resYear*365))/30;
        resDay = age-(resYear*365)+(resMonth*30);
    }

    public String getResult() {
        return resDay + ":" + resMonth + ":" + resYear;
    }
}