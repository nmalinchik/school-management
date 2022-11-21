--changeSet nmalinchik:lesson-01 logicalFilePath:objects/lesson
create table lesson.lesson
(
      id                        uuid                        not null,
      title                     varchar(255)                not null,
      description               varchar(1500)               null,

      created_by                varchar(255)                not null,
      creation_date             timestamp without time zone not null,
      last_updated_by           varchar(255)                not null,
      last_update_date          timestamp without time zone not null,
      object_version_number     bigint                      not null,

      constraint lesson_pk      primary key (id)
);

comment on table lesson.lesson is 'Lessons';

comment on column lesson.lesson.id is 'Unique ID of entity';
comment on column lesson.lesson.title is 'Title of the lesson';
comment on column lesson.lesson.description is 'Description of the lesson';

COMMENT ON column lesson.lesson.created_by IS 'User who create the entity';
COMMENT ON column lesson.lesson.creation_date IS 'Date when the entity was created';
COMMENT ON column lesson.lesson.last_updated_by IS 'User who update the entity';
COMMENT ON column lesson.lesson.last_update_date IS 'Date when the entity was updated';
COMMENT ON column lesson.lesson.object_version_number IS 'Version number of the entity';
