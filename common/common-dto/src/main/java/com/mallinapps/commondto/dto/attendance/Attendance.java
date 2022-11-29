package com.mallinapps.commondto.dto.attendance;

import java.util.List;
import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;

public record Attendance(UUID id,
                         TimetableLesson lesson,
                         Employee employee,
                         List<AttendancePresence> presences) {}
