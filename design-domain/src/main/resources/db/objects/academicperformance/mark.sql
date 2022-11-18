--changeSet nmalinchik:mark-01 logicalFilePath:objects/mark
create table academic_performance.mark
(
      id                            uuid                        not null,
      mark                          bigint                      not null,
      date_when_set                 DATE                        not null,
      lesson_id                     uuid                        not null,
      student_id                    uuid                        not null,
      employee_id                   uuid                        not null,

      created_by                    varchar(255)                not null,
      creation_date                 timestamp without time zone not null,
      last_updated_by               varchar(255)                not null,
      last_update_date              timestamp without time zone not null,
      object_version_number         bigint                      not null,

      constraint mark_pk            primary key (id),
      constraint mark_lesson_fk     foreign key (lesson_id) references lesson.lesson,
      constraint mark_student_fk    foreign key (student_id) references student.student,
      constraint mark_employee_fk   foreign key (employee_id) references employee.employee

);

comment on table academic_performance.mark is 'Marks';

comment on column academic_performance.mark.id is 'Unique ID of entity';
comment on column academic_performance.mark.mark is 'Mark';
comment on column academic_performance.mark.date_when_set is 'Date when mark set';
comment on column academic_performance.mark.lesson_id is 'Id of the lesson';
comment on column academic_performance.mark.student_id is 'Id of the student';
comment on column academic_performance.mark.employee_id is 'Id of the employee';

COMMENT ON column academic_performance.mark.created_by IS 'User who create the entity';
COMMENT ON column academic_performance.mark.creation_date IS 'Date when the entity was created';
COMMENT ON column academic_performance.mark.last_updated_by IS 'User who update the entity';
COMMENT ON column academic_performance.mark.last_update_date IS 'Date when the entity was updated';
COMMENT ON column academic_performance.mark.object_version_number IS 'Version number of the entity';
