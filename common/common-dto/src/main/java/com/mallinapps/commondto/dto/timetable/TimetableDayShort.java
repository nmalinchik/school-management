package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record TimetableDayShort(UUID id,
                                LocalDate dayDate,
                                UUID weekId,
                                List<TimetableLessonShort> timetableLessons) {}
