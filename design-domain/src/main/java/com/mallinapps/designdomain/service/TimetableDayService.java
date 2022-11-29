package com.mallinapps.designdomain.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableDayShort;
import com.mallinapps.commonlogging.Loggable;
import com.mallinapps.designdomain.domain.timetable.TimetableDayEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableWeekEntity;
import com.mallinapps.designdomain.exception.EntityNotFoundException;
import com.mallinapps.designdomain.mapper.TimetableMapper;
import com.mallinapps.designdomain.repository.TimetableWeekRepository;
import com.mallinapps.designdomain.util.DateUtils;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TimetableDayService extends CrudService<TimetableDay, TimetableDayEntity>{

    private final TimetableMapper mapper;
    private final TimetableWeekRepository weekRepository;
    private final TimetableLessonService lessonService;

    @Override
    @Transactional(readOnly = true)
    public TimetableDay findById(final UUID id) {
        return mapper.toTimetableDay(findEntityById(id));
    }

    @Transactional
    public TimetableDay create(final TimetableDayShort dto) {
        var weekEntity = getWeekById(dto.weekId());
        var saved = repository.save(mapper.toTimetableDayEntity(dto, weekEntity));
        return mapper.toTimetableDay(saved);
    }

    @Transactional
    public TimetableDay update(final UUID id, final TimetableDayShort dto) {
        var weekEntity = getWeekById(dto.weekId());
        var entity = findEntityById(id);
        var saved = repository.save(mapper.updateTimetableDayEntity(dto, entity, weekEntity));
        return mapper.toTimetableDay(saved);
    }

    @Transactional
    @Loggable
    public void copyDays(List<TimetableDayEntity> dayEntities, Integer weekNumber, UUID weekId) {
        List<Pair<TimetableDayEntity, TimetableDay>> pairs = new ArrayList<>();
        for (final TimetableDayEntity dayEntity : dayEntities) {
            var dayShort = new TimetableDayShort(null, DateUtils.getStartOrEndDayOfTheWeek(weekNumber, dayEntity.getDayDate().getDayOfWeek()), weekId, new ArrayList<>());
            pairs.add(Pair.of(dayEntity, create(dayShort)));
        }
        lessonService.copyLessons(pairs);
    }

    private TimetableWeekEntity getWeekById(UUID id) {
        checkNotNullFields(id, "timetableWeek");
        return weekRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id = %s, not found", id)));
    }
}
