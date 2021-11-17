package utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;


import static java.time.LocalDate.now;

public class Utils {

    private static Utils instance;

    private Utils(){}

    public static Utils getInstance(){
        if (instance == null){
            instance = new Utils();
        }
        return instance;
    }


    public LocalDate getNearestDayFromCalendar(DayOfWeek day){
        LocalDate date = now();
        while (date.getDayOfWeek() != day){
            date = date.plusDays(1);
        }
        return date;
    }

    public SimpleDateFormat getTimeParser(){
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        return parser;
    }
}
