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
@Table(schema = "timetable", name = "timetable_week")
public class TimetableWeekEntity extends Versioned {

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity grade;

    @ManyToMany
    @JoinTable(
            schema = "timetable",
            name = "timetable_week_day",
            joinColumns = @JoinColumn(name = "timetable_week_id"),
            inverseJoinColumns = @JoinColumn(name = "timetable_day_id"))
    private List<TimetableDayEntity> timetableDays;

}
