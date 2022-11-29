package com.mallinapps.designdomain.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.UUID;

import com.mallinapps.commondto.dto.timetable.TimetableWeek;
import com.mallinapps.commondto.dto.timetable.TimetableWeekShort;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableWeekEntity;
import com.mallinapps.designdomain.mapper.TimetableMapper;
import com.mallinapps.designdomain.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Call;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TimetableWeekService extends CrudService<TimetableWeek, TimetableWeekEntity>{

    private final TimetableMapper mapper;
    private final GradeService gradeService;
    private final TimetableDayService dayService;

    @Override
    public TimetableWeek findById(final UUID id) {
        return mapper.toTimetableWeek(findEntityById(id));
    }

    @Transactional
    public Boolean copyWeek(final UUID fromId, final Integer weekOfYear) {
        var fromEntity = findEntityById(fromId);
        var startOfTheWeek = DateUtils.getStartOrEndDayOfTheWeek(weekOfYear, DayOfWeek.MONDAY);
        var endOfTheWeek = DateUtils.getStartOrEndDayOfTheWeek(weekOfYear, DayOfWeek.SUNDAY);

        var savedWeek = create(mapper.toCopyTimetableWeekShort(fromEntity, startOfTheWeek, endOfTheWeek));

        dayService.copyDays(fromEntity.getTimetableDays(), weekOfYear, savedWeek.id());

        return true;
    }

    public TimetableWeek create(final TimetableWeekShort dto) {
        var gradeEntity = findGrade(dto);
        var entity = mapper.toTimetableWeekEntity(dto, gradeEntity);
        return mapper.toTimetableWeek(repository.save(entity));
    }

    public TimetableWeek update(final UUID id, final TimetableWeekShort dto) {
        var gradeEntity = findGrade(dto);
        var entity = mapper.updateTimetableWeekEntity(dto, findEntityById(id), gradeEntity);
        return mapper.toTimetableWeek(repository.save(entity));
    }

    private GradeEntity findGrade(final TimetableWeekShort dto) {
        checkNotNullFields(dto.gradeId(), "grade");
        return gradeService.findEntityById(dto.gradeId());
    }
}
