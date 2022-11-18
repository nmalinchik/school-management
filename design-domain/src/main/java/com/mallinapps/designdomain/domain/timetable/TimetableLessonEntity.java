package com.mallinapps.designdomain.domain.timetable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mallinapps.designdomain.domain.base.Versioned;
import com.mallinapps.designdomain.domain.enums.LessonPosition;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(schema = "timetable", name = "timetable_lesson")
public class TimetableLessonEntity extends Versioned {

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private LessonPosition position;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity gradeEntity;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private TimetableDayEntity day;

}
