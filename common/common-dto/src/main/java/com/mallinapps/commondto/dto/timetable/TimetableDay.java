package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableDay {
    private UUID id;
    private LocalDate dayDate;
    private List<TimetableLesson> timetableLessons;
}
