package com.mallinapps.designdomain.service;

import java.util.List;
import java.util.UUID;

import com.mallinapps.commondto.dto.enums.LessonPosition;
import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;
import com.mallinapps.commondto.dto.timetable.TimetableLessonShort;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableDayEntity;
import com.mallinapps.designdomain.domain.timetable.TimetableLessonEntity;
import com.mallinapps.designdomain.exception.EntityNotFoundException;
import com.mallinapps.designdomain.mapper.TimetableMapper;
import com.mallinapps.designdomain.repository.TimetableDayRepository;
import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TimetableLessonService extends CrudService<TimetableLesson, TimetableLessonEntity>{

    private final TimetableMapper mapper;
    private final TimetableDayRepository dayRepository;
    private final LessonService lessonService;

    @Override
    @Transactional(readOnly = true)
    public TimetableLesson findById(final UUID id) {
        return mapper.toTimetableLesson(findEntityById(id));
    }

    @Transactional
    public TimetableLesson create(final TimetableLessonShort dto) {
        var entities = getEntities(dto);
        var entity = mapper.toTimetableLessonEntity(dto, entities.getLeft(), entities.getRight());
        return mapper.toTimetableLesson(repository.save(entity));
    }

    @Transactional
    public TimetableLesson update(final UUID id, final TimetableLessonShort dto) {
        var entities = getEntities(dto);
        var entity = mapper.updateTimetableLessonEntity(dto, findEntityById(id), entities.getLeft(), entities.getRight());
        return mapper.toTimetableLesson(repository.save(entity));
    }

    @Transactional
    public void copyLessons(List<Pair<TimetableDayEntity, TimetableDay>> pairs) {
        for (final Pair<TimetableDayEntity, TimetableDay> pair : pairs) {
            for (final TimetableLessonEntity timetableLesson : pair.getLeft().getTimetableLessons()) {
                var lessonShort = new TimetableLessonShort(null, timetableLesson.getStartDate(), timetableLesson.getEndDate(), LessonPosition.valueOf(timetableLesson.getPosition().name()),
                                                           timetableLesson.getLesson().getId(), pair.getRight().getId());
                create(lessonShort);
            }
        }
    }

    public Pair<TimetableDayEntity, LessonEntity> getEntities(TimetableLessonShort dto){
        checkNotNullFields(dto.getDayId(), "timetableDay");
        checkNotNullFields(dto.getLessonId(), "lesson");
        var dayEntity = dayRepository.findById(dto.getDayId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id = %s, not found", dto.getDayId())));
        var lessonEntity = lessonService.findEntityById(dto.getLessonId());
        return Pair.of(dayEntity, lessonEntity);
    }
}
