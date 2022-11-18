package com.mallinapps.designdomain.domain.timetable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import com.mallinapps.designdomain.domain.base.Versioned;
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
@Table(schema = "timetable", name = "timetable_day")
public class TimetableDayEntity extends Versioned {

    @Column(name = "day_date")
    private LocalDate dayDate;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity grade;

    @ManyToMany
    @JoinTable(
            schema = "timetable",
            name = "timetable_day_lesson",
            joinColumns = @JoinColumn(name = "timetable_day_id"),
            inverseJoinColumns = @JoinColumn(name = "timetable_lesson_id"))
    private List<TimetableLessonEntity> timetableLessons;

}
