package com.test.test22;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Test3 {

    public static BigDecimal monthsBetween(final Date start, final Date end, final ZoneId zone, final int scale ) {
        final BigDecimal no31 = new BigDecimal(31);

        final LocalDate ldStart = start.toInstant().atZone(zone).toLocalDate();
        final LocalDate ldEnd = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        final int endDay = ldEnd.getDayOfMonth();
        final int endMonth = ldEnd.getMonthValue();
        final int endYear = ldEnd.getYear();
        final int lastDayOfEndMonth = ldEnd.lengthOfMonth();

        final int startDay = ldStart.getDayOfMonth();
        final int startMonth = ldStart.getMonthValue();
        final int startYear = ldStart.getYear();
        final int lastDayOfStartMonth = ldStart.lengthOfMonth();

        final BigDecimal diffInMonths = new BigDecimal((endYear - startYear)*12+(endMonth-startMonth));
        final BigDecimal fraction;
        if(endDay==startDay || (endDay==lastDayOfEndMonth && startDay==lastDayOfStartMonth)) {
            fraction = BigDecimal.ZERO;
        }
        else {
            fraction = BigDecimal.valueOf(endDay-startDay).divide(no31, scale, BigDecimal.ROUND_HALF_UP);
        }
        return diffInMonths.add(fraction);
    }

    public static BigDecimal monthsBetween(final Date start, final Date end) {
        return monthsBetween(start, end, ZoneId.systemDefault(), 20);
    }


}
