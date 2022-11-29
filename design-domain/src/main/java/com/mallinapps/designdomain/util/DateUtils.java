package com.mallinapps.designdomain.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

    public static LocalDate getStartOrEndDayOfTheWeek(Integer weekOfYear, DayOfWeek dayOfWeek) {
        return LocalDate.now()
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekOfYear)
                .with(TemporalAdjusters.previousOrSame(dayOfWeek));
    }
}
