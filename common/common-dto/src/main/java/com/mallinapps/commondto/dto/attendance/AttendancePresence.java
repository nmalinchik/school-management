package com.mallinapps.commondto.dto.attendance;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendancePresence {
    private UUID id;
    private Boolean present;
    private Student student;
    private Attendance attendance;
}
