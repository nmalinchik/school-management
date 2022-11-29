package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mallinapps.commondto.dto.enums.LessonPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimetableLessonShort {

    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LessonPosition position;
    private UUID lessonId;
    private UUID dayId;

}
