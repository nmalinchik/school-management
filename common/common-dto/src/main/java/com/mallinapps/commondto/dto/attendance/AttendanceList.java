package com.mallinapps.commondto.dto.attendance;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;

public record AttendanceList(List<Attendance> attendances, CommonPageResource page) {}
