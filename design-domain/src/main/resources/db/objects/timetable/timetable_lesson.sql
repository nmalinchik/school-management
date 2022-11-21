--changeSet nmalinchik:timetable_lesson-01 logicalFilePath:objects/timetable_lesson
create table timetable.timetable_lesson
(
      id                                        uuid                        not null,
      start_date                                timestamp without time zone not null,
      end_date                                  timestamp without time zone not null,
      position                                  varchar(255)                not null,
      grade_id                                  uuid                        not null,
      lesson_id                                 uuid                        not null,
      day_id                                    uuid                        not null,

      created_by                                varchar(255)                not null,
      creation_date                             timestamp without time zone not null,
      last_updated_by                           varchar(255)                not null,
      last_update_date                          timestamp without time zone not null,
      object_version_number                     bigint                      not null,

      constraint timetable_lesson_pk            primary key (id),
      constraint timetable_lesson_grade_fk      foreign key (grade_id) references student.grade,
      constraint timetable_lesson_lesson_fk     foreign key (lesson_id) references lesson.lesson,
      constraint timetable_lesson_day_fk        foreign key (day_id) references timetable.timetable_day
);

comment on table timetable.timetable_lesson is 'One lesson from day timetable';

comment on column timetable.timetable_lesson.id is 'Unique ID of entity';
comment on column timetable.timetable_lesson.start_date is 'When lesson starts';
comment on column timetable.timetable_lesson.end_date is 'When lesson ends';
comment on column timetable.timetable_lesson.position is 'Position in schedule';
comment on column timetable.timetable_lesson.grade_id is 'Id of the grade';
comment on column timetable.timetable_lesson.lesson_id is 'Id of the lesson';
comment on column timetable.timetable_lesson.day_id is 'Id of the timetable day';

COMMENT ON column timetable.timetable_lesson.created_by IS 'User who create the entity';
COMMENT ON column timetable.timetable_lesson.creation_date IS 'Date when the entity was created';
COMMENT ON column timetable.timetable_lesson.last_updated_by IS 'User who update the entity';
COMMENT ON column timetable.timetable_lesson.last_update_date IS 'Date when the entity was updated';
COMMENT ON column timetable.timetable_lesson.object_version_number IS 'Version number of the entity';
