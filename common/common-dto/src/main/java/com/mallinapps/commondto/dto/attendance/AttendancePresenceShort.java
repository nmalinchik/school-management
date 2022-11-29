package com.mallinapps.commondto.dto.attendance;

import java.util.UUID;

public record AttendancePresenceShort(UUID id,
                                      Boolean present,
                                      UUID studentId,
                                      UUID attendanceId) {

}
