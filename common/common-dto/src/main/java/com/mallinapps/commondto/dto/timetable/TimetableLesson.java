package com.mallinapps.commondto.dto.timetable;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.designdomain.domain.enums.LessonPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableLesson {

    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LessonPosition position;
    private Grade grade;
    private Lesson lesson;
    private TimetableDay day;

}
