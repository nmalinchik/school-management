package com.mallinapps.commondto.mapstruct;

import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;
import com.mallinapps.commondto.dto.timetable.TimetableWeek;
import com.mallinapps.commondto.mapstruct.LessonMapper;
import com.mallinapps.commondto.mapstruct.StudentMapper;
import com.mallinapps.designdomain.domain.timetable.TimetableDayEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableLessonEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableWeekEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {StudentMapper.class, LessonMapper.class},
        builder = @Builder(disableBuilder = true))
public interface TimetableMapper {

    TimetableDay toTimetableDay(TimetableDayEntity entity);

    @AfterMapping
    default void updateLessons(@MappingTarget TimetableDay day) {
        day.timetableLessons().forEach(l -> l.setDay(day));
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimetableDayEntity toTimetableDayEntity(TimetableDay timetableDay);

    @Mapping(target = "day", ignore = true)
    TimetableLesson toTimetableLesson(TimetableLessonEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimetableLessonEntity toTimetableLessonEntity(TimetableLesson timetableLesson);

    TimetableWeek toTimetableWeek(TimetableWeekEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimetableWeekEntity toTimetableWeekEntity(TimetableWeek timetableWeek);

}
