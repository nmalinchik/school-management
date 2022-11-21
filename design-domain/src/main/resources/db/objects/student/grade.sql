--changeSet nmalinchik:lesson-01 logicalFilePath:objects/lesson
create table student.grade
(
      id                        uuid                        not null,
      grade                     varchar(255)                not null,
      letter                    varchar(2)                  not null,

      created_by                varchar(255)                not null,
      creation_date             timestamp without time zone not null,
      last_updated_by           varchar(255)                not null,
      last_update_date          timestamp without time zone not null,

      constraint grade_pk       primary key (id)
);

comment on table student.grade is 'Grades';

comment on column student.grade.id is 'Unique ID of entity';
comment on column student.grade.grade is 'Grade';
comment on column student.grade.letter is 'The letter of the grade';

COMMENT ON column student.grade.created_by IS 'User who create the entity';
COMMENT ON column student.grade.creation_date IS 'Date when the entity was created';
COMMENT ON column student.grade.last_updated_by IS 'User who update the entity';
COMMENT ON column student.grade.last_update_date IS 'Date when the entity was updated';
