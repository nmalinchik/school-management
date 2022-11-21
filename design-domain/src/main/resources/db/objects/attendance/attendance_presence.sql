--changeSet nmalinchik:attendance_presence-01 logicalFilePath:objects/attendance_presence
create table attendance.attendance_presence
(
      id                            UUID                        not null,
      is_present                    BOOLEAN                     not null default false,
      student_id                    uuid                        not null,
      attendance_id                 uuid                        not null,

      created_by                    varchar(255)                not null,
      creation_date                 timestamp without time zone not null,
      last_updated_by               varchar(255)                not null,
      last_update_date              timestamp without time zone not null,

      constraint attendance_presence_pk             primary key (id),
      constraint attendance_presence_student_fk     foreign key (student_id) references student.student,
      constraint attendance_presence_attendance_fk  foreign key (attendance_id) references attendance.attendance
);

comment on table attendance.attendance_presence is 'Presence';

comment on column attendance.attendance_presence.id is 'Unique ID of entity';
comment on column attendance.attendance_presence.is_present is 'Is student present on the lesson';
comment on column attendance.attendance_presence.student_id is 'Id of the student';
comment on column attendance.attendance_presence.attendance_id is 'Id of the attendance';

COMMENT ON column attendance.attendance_presence.created_by IS 'User who create the entity';
COMMENT ON column attendance.attendance_presence.creation_date IS 'Date when the entity was created';
COMMENT ON column attendance.attendance_presence.last_updated_by IS 'User who update the entity';
COMMENT ON column attendance.attendance_presence.last_update_date IS 'Date when the entity was updated';
