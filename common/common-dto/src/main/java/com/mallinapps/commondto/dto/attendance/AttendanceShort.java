package com.mallinapps.commondto.dto.attendance;

import java.util.List;
import java.util.UUID;

public record AttendanceShort(UUID id,
                              UUID timetableLessonId,
                              UUID employeeId,
                              List<AttendancePresenceShort> presences) {}
