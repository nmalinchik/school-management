package com.mallinapps.designdomain.repository;

import java.util.List;
import java.util.UUID;

import com.mallinapps.designdomain.domain.timetable.TimetableLessonEntity;

public interface TimetableLessonRepository extends GenericRepository<TimetableLessonEntity> {

    List<TimetableLessonEntity> findAllByLessonId(UUID lessonId);

}
