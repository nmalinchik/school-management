package com.mallinapps.designdomain.domain.timetable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import com.mallinapps.designdomain.domain.base.Versioned;
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
    @JoinColumn(name = "week_id")
    private TimetableWeekEntity week;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "day", orphanRemoval = true)
    private List<TimetableLessonEntity> timetableLessons;

}
