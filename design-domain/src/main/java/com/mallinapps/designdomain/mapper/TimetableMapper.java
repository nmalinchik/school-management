package com.mallinapps.designdomain.mapper;

import java.time.LocalDate;

import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableDayShort;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;
import com.mallinapps.commondto.dto.timetable.TimetableLessonShort;
import com.mallinapps.commondto.dto.timetable.TimetableWeek;
import com.mallinapps.commondto.dto.timetable.TimetableWeekShort;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.student.GradeEntity;
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

    @Mapping(target = "id", source = "timetableDay.id")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "timetableLessons", ignore = true)
    TimetableDayEntity toTimetableDayEntity(TimetableDayShort timetableDay, TimetableWeekEntity week);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "timetableLessons", ignore = true)
    TimetableDayEntity updateTimetableDayEntity(TimetableDayShort timetableDay, @MappingTarget TimetableDayEntity entity, TimetableWeekEntity week);

    TimetableLesson toTimetableLesson(TimetableLessonEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimetableLessonEntity toTimetableLessonEntity(TimetableLessonShort timetableLesson, TimetableDayEntity day, LessonEntity lesson);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimetableLessonEntity updateTimetableLessonEntity(TimetableLessonShort timetableLesson, @MappingTarget TimetableLessonEntity entity, TimetableDayEntity day, LessonEntity lesson);

    TimetableWeek toTimetableWeek(TimetableWeekEntity entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "timetableDays", ignore = true)
    @Mapping(target = "grade", source = "grade")
    TimetableWeekEntity toTimetableWeekEntity(TimetableWeekShort dto, GradeEntity grade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "timetableDays", ignore = true)
    @Mapping(target = "grade", source = "grade")
    TimetableWeekEntity updateTimetableWeekEntity(TimetableWeekShort dto, @MappingTarget TimetableWeekEntity entity, GradeEntity grade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timetableDays", ignore = true)
    @Mapping(target = "gradeId", source = "entity.grade.id")
    TimetableWeekShort toCopyTimetableWeekShort(TimetableWeekEntity entity, LocalDate startDate, LocalDate endDate);

}
