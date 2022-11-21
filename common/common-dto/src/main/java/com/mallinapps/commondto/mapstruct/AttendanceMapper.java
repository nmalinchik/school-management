package com.mallinapps.commondto.mapstruct;

import com.mallinapps.commondto.dto.attendance.Attendance;
import com.mallinapps.commondto.dto.attendance.AttendancePresence;
import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.designdomain.domain.attendance.AttendanceEntity;
import com.mallinapps.designdomain.domain.attendance.AttendancePresenceEntity;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {EmployeeMapper.class, TimetableMapper.class, StudentMapper.class},
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
