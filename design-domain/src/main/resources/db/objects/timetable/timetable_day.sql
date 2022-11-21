--changeSet nmalinchik:timetable_day-01 logicalFilePath:objects/timetable_day
create table timetable.timetable_day
(
      id                                        uuid                        not null,
      day_date                                  DATE                         not null,
      grade_id                                  uuid                        not null,

      created_by                                varchar(255)                not null,
      creation_date                             timestamp without time zone not null,
      last_updated_by                           varchar(255)                not null,
      last_update_date                          timestamp without time zone not null,
      object_version_number                     bigint                      not null,

      constraint timetable_day_pk            primary key (id),
      constraint timetable_day_grade_fk      foreign key (grade_id) references student.grade
);

comment on table timetable.timetable_day is 'Day timetable';

comment on column timetable.timetable_day.id is 'Unique ID of entity';
comment on column timetable.timetable_day.day_date is 'Date of timetable day';
comment on column timetable.timetable_day.grade_id is 'Id of the grade';

COMMENT ON column timetable.timetable_day.created_by IS 'User who create the entity';
COMMENT ON column timetable.timetable_day.creation_date IS 'Date when the entity was created';
COMMENT ON column timetable.timetable_day.last_updated_by IS 'User who update the entity';
COMMENT ON column timetable.timetable_day.last_update_date IS 'Date when the entity was updated';
COMMENT ON column timetable.timetable_day.object_version_number IS 'Version number of the entity';
