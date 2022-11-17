--changeSet nmalinchik:student-01 logicalFilePath:objects/student
create table student.student
(
      id                        uuid                        not null,
      first_name                varchar(255)                not null,
      last_name                 varchar(255)                not null,
      middle_name               varchar(255)                not null,
      date_of_birth             DATE                        not null,
      grade_id                  uuid                        not null,

      created_by                varchar(255)                not null,
      creation_date             timestamp without time zone not null,
      last_updated_by           varchar(255)                not null,
      last_update_date          timestamp without time zone not null,
      object_version_number     bigint                      not null,

      constraint student_pk      primary key (id),
      constraint student_grade_fk    foreign key (grade_id) references student.grade
);

comment on table student.student is 'Lessons';

comment on column student.student.id is 'Unique ID of entity';
comment on column student.student.first_name is 'First name of the student';
comment on column student.student.first_name is 'Last name of the student';
comment on column student.student.first_name is 'Middle name of the student';
comment on column student.student.date_of_birth is 'Date of birth of the student';
comment on column student.student.grade_id is 'Id of the grade';

COMMENT ON column student.student.created_by IS 'User who create the entity';
COMMENT ON column student.student.creation_date IS 'Date when the entity was created';
COMMENT ON column student.student.last_updated_by IS 'User who update the entity';
COMMENT ON column student.student.last_update_date IS 'Date when the entity was updated';
COMMENT ON column student.student.object_version_number IS 'Version number of the entity';
