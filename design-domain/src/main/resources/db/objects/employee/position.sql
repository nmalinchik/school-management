--changeSet nmalinchik:position-01 logicalFilePath:objects/position
create table employee.position
(
      id                        uuid                        not null,
      title                     varchar(255)                not null unique,

      created_by                varchar(255)                not null,
      creation_date             timestamp without time zone not null,
      last_updated_by           varchar(255)                not null,
      last_update_date          timestamp without time zone not null,

      constraint position_pk      primary key (id)
);

comment on table employee.position is 'Positions';

comment on column employee.position.id is 'Unique ID of entity';
comment on column employee.position.title is 'Title of the position';

COMMENT ON column employee.position.created_by IS 'User who create the entity';
COMMENT ON column employee.position.creation_date IS 'Date when the entity was created';
COMMENT ON column employee.position.last_updated_by IS 'User who update the entity';
COMMENT ON column employee.position.last_update_date IS 'Date when the entity was updated';
