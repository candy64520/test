package com.test.test22;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {


    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date time = format.parse("2022.02.28");
        Date queryDate = format.parse("2021.09.30");

        Timestamp startTime = new Timestamp(time.getTime());

        Timestamp endTime = new Timestamp(queryDate.getTime());

        Double diffMonth  = oracle_months_between(startTime,endTime);
        System.out.println("diffMonth---"+diffMonth);
    }

    public static double oracle_months_between(Timestamp endDate, Timestamp startDate) {

        //MONTHS_BETWEEN returns number of months between dates date1 and date2.
        // If date1 is later than date2, then the result is positive.
        // If date1 is earlier than date2, then the result is negative.
        // If date1 and date2 are either the same days of the month or both last days of months, then the result is always an integer.
        // Otherwise Oracle Database calculates the fractional portion of the result based on a 31-day month and considers the difference in time components date1 and date2.

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endDateString = sdf.format(endDate), startDateString = sdf.format(startDate);

        int startDateYear = Integer.parseInt(startDateString.substring(0,4)), startDateMonth = Integer.parseInt(startDateString.substring(5,7)), startDateDay = Integer.parseInt(startDateString.substring(8,10));
        int endDateYear = Integer.parseInt(endDateString.substring(0,4)), endDateMonth = Integer.parseInt(endDateString.substring(5,7)), endDateDay = Integer.parseInt(endDateString.substring(8,10));

        boolean endDateLDM = is_last_day(endDate), startDateLDM = is_last_day(startDate);

        int diffMonths = -startDateYear*12 - startDateMonth + endDateYear * 12 + endDateMonth;
        /*extract_day(startDate) == extract_day(endDate)*/
        if (endDateLDM && startDateLDM || startDate.equals(endDate)){
            // If date1 and date2 are either the same days of the month or both last days of months, then the result is always an integer.
            return (double)(diffMonths);
        }

        double diffDays = (endDateDay - startDateDay)/31.;

        Timestamp dStart = Timestamp.valueOf("1970-01-01 " + startDateString.substring(11)), dEnd = Timestamp.valueOf("1970-01-01 " + endDateString.substring(11));

        return diffMonths + diffDays + (dEnd.getTime()-dStart.getTime())/1000./3600./24./31.;
    }

    public static boolean is_last_day(Timestamp ts){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ts);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return max == Integer.parseInt((new SimpleDateFormat("dd").format(ts)));
    }
}
