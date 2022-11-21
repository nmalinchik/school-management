package com.mallinapps.designdomain.domain.attendance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import com.mallinapps.designdomain.domain.base.Versioned;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableLessonEntity;
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
@Table(schema = "attendance", name = "attendance")
public class AttendanceEntity extends Versioned {

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private TimetableLessonEntity lesson;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attendance", orphanRemoval = true)
    private List<AttendancePresenceEntity> presences;

}
