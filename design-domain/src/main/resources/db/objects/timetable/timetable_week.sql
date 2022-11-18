--changeSet nmalinchik:timetable_week-01 logicalFilePath:objects/timetable_week
create table timetable.timetable_week
(
      id                                        uuid                        not null,
      start_date                                timestamp without time zone not null,
      end_date                                  timestamp without time zone not null,
      grade_id                                  uuid                        not null,

      created_by                                varchar(255)                not null,
      creation_date                             timestamp without time zone not null,
      last_updated_by                           varchar(255)                not null,
      last_update_date                          timestamp without time zone not null,
      object_version_number                     bigint                      not null,

      constraint timetable_week_pk            primary key (id),
      constraint timetable_week_grade_fk      foreign key (grade_id) references student.grade
);

comment on table timetable.timetable_week is 'Week timetable';

comment on column timetable.timetable_week.id is 'Unique ID of entity';
comment on column timetable.timetable_week.start_date is 'When week starts';
comment on column timetable.timetable_week.end_date is 'When week ends';
comment on column timetable.timetable_week.grade_id is 'Id of the grade';

COMMENT ON column timetable.timetable_week.created_by IS 'User who create the entity';
COMMENT ON column timetable.timetable_week.creation_date IS 'Date when the entity was created';
COMMENT ON column timetable.timetable_week.last_updated_by IS 'User who update the entity';
COMMENT ON column timetable.timetable_week.last_update_date IS 'Date when the entity was updated';
COMMENT ON column timetable.timetable_week.object_version_number IS 'Version number of the entity';
