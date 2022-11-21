package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;

public record TimetableDay(UUID id,
                           LocalDate dayDate,
                           Grade grade,
                           List<TimetableLesson> timetableLessons) {}
