--changeSet nmalinchik:attendance-01 logicalFilePath:objects/attendance
create table attendance.attendance
(
      id                                    uuid                        not null,
      lesson_id                             uuid                        null,
      employee_id                           uuid                        null,

      created_by                            varchar(255)                not null,
      creation_date                         timestamp without time zone not null,
      last_updated_by                       varchar(255)                not null,
      last_update_date                      timestamp without time zone not null,
      object_version_number                 bigint                      not null,

      constraint attendance_pk              primary key (id),
      constraint attendance_lesson_fk       foreign key (lesson_id) references timetable.timetable_lesson,
      constraint attendance_employee_fk     foreign key (employee_id) references employee.employee
);

comment on table attendance.attendance is 'Attendance';

comment on column attendance.attendance.id is 'Unique ID of entity';
comment on column attendance.attendance.lesson_id is 'Lesson of the attendance';
comment on column attendance.attendance.employee_id is 'Employee filled the attendance';

COMMENT ON column attendance.attendance.created_by IS 'User who create the entity';
COMMENT ON column attendance.attendance.creation_date IS 'Date when the entity was created';
COMMENT ON column attendance.attendance.last_updated_by IS 'User who update the entity';
COMMENT ON column attendance.attendance.last_update_date IS 'Date when the entity was updated';
COMMENT ON column attendance.attendance.object_version_number IS 'Version number of the entity';
