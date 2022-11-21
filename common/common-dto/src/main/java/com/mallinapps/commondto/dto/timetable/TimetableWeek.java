package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;

public record TimetableWeek(UUID id,
                            LocalDate startDate,
                            LocalDate endDate,
                            Grade grade,
                            List<TimetableDay> timetableDays) {}
