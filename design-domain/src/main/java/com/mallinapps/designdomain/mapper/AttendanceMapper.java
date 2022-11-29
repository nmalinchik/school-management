package com.mallinapps.designdomain.mapper;

import com.mallinapps.commondto.dto.attendance.Attendance;
import com.mallinapps.commondto.dto.attendance.AttendancePresence;
import com.mallinapps.designdomain.domain.attendance.AttendanceEntity;
import com.mallinapps.designdomain.domain.attendance.AttendancePresenceEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {EmployeeMapper.class, TimetableMapper.class, StudentMapper.class, LessonMapper.class},
        builder = @Builder(disableBuilder = true))
public interface AttendanceMapper {

    Attendance toAttendance(AttendanceEntity entity);

    @AfterMapping
    default void updateAttendancePresence(@MappingTarget Attendance attendance) {
        attendance.presences().forEach(attendancePresence -> attendancePresence.setAttendance(attendance));
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "lesson", ignore = true) //todo fix it in attendance service
    AttendanceEntity toAttendanceEntity(Attendance attendance);

    AttendancePresence toAttendancePresence(AttendancePresenceEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "attendance", ignore = true)
    AttendancePresenceEntity toAttendancePresenceEntity(AttendancePresence attendancePresence);

}
