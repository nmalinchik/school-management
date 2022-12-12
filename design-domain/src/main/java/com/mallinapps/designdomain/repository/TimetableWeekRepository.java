package com.mallinapps.designdomain.repository;

import java.util.UUID;

import com.mallinapps.designdomain.domain.timetable.TimetableWeekEntity;

public interface TimetableWeekRepository extends GenericRepository<TimetableWeekEntity> {

    void deleteAllByGradeId(UUID gradeId);

}
