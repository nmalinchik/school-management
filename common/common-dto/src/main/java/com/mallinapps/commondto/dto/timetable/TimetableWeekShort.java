package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record TimetableWeekShort(UUID id,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 UUID gradeId,
                                 List<TimetableDayShort> timetableDays) {}
