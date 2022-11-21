package com.mallinapps.designdomain.domain.academicperformance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import com.mallinapps.designdomain.domain.base.Versioned;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
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
@Table(schema = "academic_performance", name = "mark")
public class MarkEntity extends Versioned {

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "date_when_set")
    private LocalDate dateWhenSet;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity teacher;

}
