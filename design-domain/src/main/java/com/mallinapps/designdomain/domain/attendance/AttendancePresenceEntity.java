package com.mallinapps.designdomain.domain.attendance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
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
@Table(schema = "attendance", name = "attendance_presence")
public class AttendancePresenceEntity extends BusinessEntity {

    @Column(name = "is_present")
    private Boolean present;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "attendance_id")
    private AttendanceEntity attendance;

}
